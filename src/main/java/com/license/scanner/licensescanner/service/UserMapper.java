package com.license.scanner.licensescanner.service;

import com.license.scanner.licensescanner.model.User;
import com.license.scanner.licensescanner.model.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<UserDto> toDto(List<User> user) {
        return user.stream().map(e -> new UserDto(e.getId(), e.getRestaurant(), e.getFirstName(), e.getLastName(), e.getUsername(), e.getIsActive())
        ).collect(Collectors.toList());
    }
}
