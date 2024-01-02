package com.cbc.authenticate.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long id;

    private String userName;
    private String password;

    private List<Long> roles;

    private boolean enabled;
}
