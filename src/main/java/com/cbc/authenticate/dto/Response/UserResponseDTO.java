package com.cbc.authenticate.dto.Response;

import com.cbc.authenticate.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private Long id;
    private String userName;
    private Set<Role> roles; // A set of role names
    private boolean enabled;
}