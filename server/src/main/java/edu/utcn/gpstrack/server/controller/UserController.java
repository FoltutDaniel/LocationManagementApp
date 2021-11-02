package edu.utcn.gpstrack.server.controller;

import edu.utcn.gpstrack.server.DTO.user.UserDTO;
import edu.utcn.gpstrack.server.DTO.user.UserLoginDTO;
import edu.utcn.gpstrack.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public Integer register(@RequestBody UserDTO userDTO){
        return userService.registerUser(userDTO);
    }

    @PostMapping(value = "/login")
    public UserDTO login(@RequestBody UserLoginDTO userLoginDTO){
        return userService.loginUser(userLoginDTO);
    }

}
