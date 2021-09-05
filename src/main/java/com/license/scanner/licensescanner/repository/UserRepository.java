package com.license.scanner.licensescanner.repository;

import com.license.scanner.licensescanner.model.User;
import com.license.scanner.licensescanner.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
