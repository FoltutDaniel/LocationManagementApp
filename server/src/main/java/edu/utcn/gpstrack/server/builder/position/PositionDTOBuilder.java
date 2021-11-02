package edu.utcn.gpstrack.server.builder.position;

import edu.utcn.gpstrack.server.DTO.PositionDTO;
import edu.utcn.gpstrack.server.entity.Position;

public class PositionDTOBuilder {

    public static PositionDTO generateDTOFromEntity(Position position){

        return new PositionDTO(
                position.getId(),
                position.getTerminalId(),
                position.getLatitude(),
                position.getLongitude(),
                position.getCreationDate(),
                position.getUser()
        );
    }

    public static Position generateEntityFromDto(PositionDTO positionDTO){

        return new Position(
                positionDTO.getId(),
                positionDTO.getTerminalId(),
                positionDTO.getLatitude(),
                positionDTO.getLongitude(),
                positionDTO.getCreationDate(),
                positionDTO.getUser()
        );
    }
}
