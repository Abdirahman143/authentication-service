package com.cbc.authenticate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User name is required")
    @NotNull
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String userName;

    @NotBlank(message = "Password is required")
    @NotNull
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$",
            message = "Password must be at least 8 characters long, include an uppercase letter," +
                    " a special character, a number, and not have repetitive characters.")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id_fk", referencedColumnName = "id")
    private List<Role> roles;

    private boolean enabled;
}
