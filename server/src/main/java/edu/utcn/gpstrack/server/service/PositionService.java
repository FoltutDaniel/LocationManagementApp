package edu.utcn.gpstrack.server.service;

import edu.utcn.gpstrack.server.DTO.PositionDTO;
import edu.utcn.gpstrack.server.builder.position.PositionDTOBuilder;
import edu.utcn.gpstrack.server.entity.Position;
import edu.utcn.gpstrack.server.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Radu Miron
 * @version 1
 */
@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer create(PositionDTO positionDTO) {

        positionRepository.save(PositionDTOBuilder.generateEntityFromDto(positionDTO));

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
