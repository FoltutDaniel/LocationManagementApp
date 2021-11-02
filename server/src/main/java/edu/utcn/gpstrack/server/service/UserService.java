package edu.utcn.gpstrack.server.service;

import edu.utcn.gpstrack.server.DTO.UserDTO;
import edu.utcn.gpstrack.server.builder.user.UserDTOBuilder;
import edu.utcn.gpstrack.server.entity.User;
import edu.utcn.gpstrack.server.exception.ResourceNotFoundException;
import edu.utcn.gpstrack.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Integer registerUser(UserDTO userDTO){

        User registeredUser = UserDTOBuilder.generateEntityFromDto(userDTO);

        userRepository.save(registeredUser);

        return registeredUser.getId();
    }

    @Transactional
    public UserDTO loginUser(String username, String password){

        User currentUser = userRepository.findUserByUsername(username);

        if(currentUser == null){
            System.out.println("Nu avem user din ala tati");
            return null;
        }else if(currentUser.getPassword().equals(password)){
            return UserDTOBuilder.generateDTOFromEntity(currentUser);
        }else{
            System.out.println("Parola greista fra");
            return null;
        }
    }

    @Transactional
    public Integer deleteUser(UserDTO userDTO){

        User currentUser = UserDTOBuilder.generateEntityFromDto(userDTO);

        userRepository.delete(currentUser);

        return currentUser.getId();
    }


}
