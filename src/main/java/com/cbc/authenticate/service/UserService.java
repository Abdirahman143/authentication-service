package com.cbc.authenticate.service;

import com.cbc.authenticate.dto.Request.UserRequestDTO;
import com.cbc.authenticate.dto.Response.UserResponseDTO;

public interface UserService  {
    UserResponseDTO registerNewUser(UserRequestDTO userRequestDTO);
}
