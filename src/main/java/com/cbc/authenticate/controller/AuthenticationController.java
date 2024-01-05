package com.cbc.authenticate.controller;

import com.cbc.authenticate.dto.Request.AuthRequestDTO;
import com.cbc.authenticate.dto.Response.JwtResponseDTO;
import com.cbc.authenticate.security.JwtUtil;
import com.cbc.authenticate.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
        try {
            String jwt = authenticationService.authenticateAndGetToken(authRequestDTO);
            return ResponseEntity.ok(new JwtResponseDTO(jwt));
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password.", e);
        }
    }
}