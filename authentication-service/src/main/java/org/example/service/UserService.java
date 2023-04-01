package org.example.service;

import org.example.dto.request.UserRequest;
import org.example.dto.response.GenericResponse;
import org.example.dto.response.UserResponse;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public  GenericResponse login(UserRequest userRequest) {
        Optional<User> user = userRepository.findById(userRequest.getUsername());
        if (user.isPresent()) {
            if (user.get().getPassword().equals(userRequest.getPassword())) {
                return new GenericResponse(Constants.SUCCESS,"Login Successful");
            } else {
                return new GenericResponse(Constants.ERROR,"Invalid password");
            }

        } else {
           return new GenericResponse(Constants.ERROR,"User not available");
        }
    }

    public GenericResponse register(UserRequest userRequest) {
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .role(userRequest.getRole())
                .build();

        User response = userRepository.save(user);

        /*return UserResponse.builder()
                .username(response.getUsername())
                .role(response.getRole())
                .build();*/
        return new GenericResponse(Constants.SUCCESS,"User Registered Successfully");
    }

}
