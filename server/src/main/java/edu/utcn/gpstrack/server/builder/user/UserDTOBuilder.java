package edu.utcn.gpstrack.server.builder.user;

import edu.utcn.gpstrack.server.DTO.user.UserDTO;
import edu.utcn.gpstrack.server.builder.position.PositionDTOBuilder;
import edu.utcn.gpstrack.server.entity.User;

import java.util.stream.Collectors;

public class UserDTOBuilder {

    public static UserDTO generateDTOFromEntity(User user){

       return new UserDTO(
               user.getId(),
               user.getUsername(),
               user.getPassword(),
               user.getRole(),
               user.getPositions().stream()
                       .map(PositionDTOBuilder::generateDTOFromEntity)
                       .collect(Collectors.toList())
       );
    }

    public static User generateEntityFromDto(UserDTO userDTO){


        return new User(
                userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getRole()
        );
    }
}
