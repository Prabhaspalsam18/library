package org.example.controller;

import org.example.dto.request.UserRequest;
import org.example.dto.response.GenericResponse;
import org.example.dto.response.UserResponse;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public GenericResponse register(@RequestBody UserRequest userRequest) {
        return userService.register(userRequest);
    }

    @PostMapping("/login")
    public GenericResponse login(@RequestBody UserRequest userRequest) {
        return userService.login(userRequest);
    }
}
