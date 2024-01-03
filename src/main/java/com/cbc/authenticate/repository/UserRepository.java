package com.cbc.authenticate.repository;

import com.cbc.authenticate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
