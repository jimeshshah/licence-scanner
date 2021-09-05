package com.license.scanner.licensescanner.service;

import com.license.scanner.licensescanner.model.User;
import com.license.scanner.licensescanner.model.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List<UserDto> getAllUsers();
}
