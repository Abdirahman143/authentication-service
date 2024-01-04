package com.cbc.authenticate.controller;

import com.cbc.authenticate.dto.Request.UserRequestDTO;
import com.cbc.authenticate.dto.Response.UserResponseDTO;
import com.cbc.authenticate.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {
    static private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    private final UserServiceImpl userService;

    @Autowired
    public RegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        try {
            UserResponseDTO savedUser = userService.registerNewUser(userRequestDTO);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
             logger.error("Error occurred during user registration");
            // You might want to handle specific exceptions differently and provide more context to the client.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
