package edu.utcn.gpstrack.server.controller;

import edu.utcn.gpstrack.server.DTO.PositionDTO;
import edu.utcn.gpstrack.server.entity.Position;
import edu.utcn.gpstrack.server.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Radu Miron
 * @version 1
 */
@RestController
@RequestMapping("/positions")
@CrossOrigin
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping(value = "/create")
    public Integer create(@RequestBody PositionDTO positionDTO) {
        return positionService.create(positionDTO);
    }

    @GetMapping(value = "/{terminalId}")
    public PositionDTO getPosition(@PathVariable("terminalId")String terminalId){
        return positionService.getPosition(terminalId);
    }
}
