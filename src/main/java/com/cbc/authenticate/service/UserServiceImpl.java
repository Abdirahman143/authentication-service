package com.cbc.authenticate.service;

import com.cbc.authenticate.dto.Request.UserRequestDTO;
import com.cbc.authenticate.dto.Response.UserResponseDTO;
import com.cbc.authenticate.entity.Role;
import com.cbc.authenticate.entity.User;
import com.cbc.authenticate.repository.RoleRepository;
import com.cbc.authenticate.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl  implements  UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserResponseDTO registerNewUser(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setUserName(userRequestDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        user.setEnabled(userRequestDTO.isEnabled());
        Set<Role> roleSet = new HashSet<>();
        userRequestDTO.getRoleIds().forEach(roleId->roleSet.add(roleRepository.findById(roleId).orElse(null)));
        user.setRoles(roleSet);

        User savedUser = userRepository.save(user);
        return new UserResponseDTO(savedUser.getId(), savedUser.getUserName(), savedUser.getRoles(), savedUser.isEnabled());
    }
}
