package edu.utcn.gpstrack.server.service;

import edu.utcn.gpstrack.server.DTO.position.PositionDTO;
import edu.utcn.gpstrack.server.builder.position.PositionDTOBuilder;
import edu.utcn.gpstrack.server.entity.Position;
import edu.utcn.gpstrack.server.entity.User;
import edu.utcn.gpstrack.server.exception.ResourceNotFoundException;
import edu.utcn.gpstrack.server.repository.PositionRepository;
import edu.utcn.gpstrack.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Radu Miron
 * @version 1
 */
@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer create(PositionDTO positionDTO, Integer userId) {

        Position newPosition = PositionDTOBuilder.generateEntityFromDto(positionDTO);

        Optional<User> currentUser = userRepository.findById(userId);

        if(!currentUser.isPresent()){
            System.out.println("Nu mai avem..");
        }else{
            currentUser.get().addPosition(newPosition);
        }

        positionRepository.save(newPosition);

        return positionDTO.getId();
    }

    @Transactional
    public PositionDTO getPosition(String terminalId){

        Position currentPosition = positionRepository.getPositionByTerminalId(terminalId);

        if(currentPosition != null){
            return PositionDTOBuilder.generateDTOFromEntity(currentPosition);
        }else{
            return null;
        }
    }
}
