package com.cbc.authenticate.repository;

import com.cbc.authenticate.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
