package com.cbc.authenticate.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
        @NotBlank
        @Size(min = 3, max = 50)
        private String userName;

        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$")
        private String password;

        private Set<Long> roleIds; // IDs of the roles to be assigned to the user

        private boolean enabled;
    }

