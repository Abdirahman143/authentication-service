package com.cbc.authenticate.service;

import com.cbc.authenticate.controller.RegistrationController;
import com.cbc.authenticate.dto.Request.AuthRequestDTO;
import com.cbc.authenticate.repository.UserRepository;
import com.cbc.authenticate.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    static private final Logger logger = LoggerFactory.getLogger(AuthenticationManager.class);
    public String authenticateAndGetToken(AuthRequestDTO authRequestDTO) throws AuthenticationException {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDTO.getUserName(), authRequestDTO.getPassword()));
            return jwtUtil.generateToken(authRequestDTO.getUserName());
        } catch (AuthenticationException e) {
            // Log the exception with details for debugging
            logger.error("Authentication failed for user: {}", authRequestDTO.getUserName(), e);
            throw e;  // Rethrow the exception to be handled by the controller
        }
    }

}
