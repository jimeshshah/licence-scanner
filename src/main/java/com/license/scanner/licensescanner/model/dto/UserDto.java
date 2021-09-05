package com.license.scanner.licensescanner.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.license.scanner.licensescanner.model.Restaurant;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private Long id;

    private Restaurant restaurant;

    private String firstName;

    private String lastName;

    private String userName;

    private Boolean isActive;

    public UserDto(Long id, Restaurant restaurant, String firstName, String lastName, String userName, Boolean isActive) {
        this.id = id;
        this.restaurant = restaurant;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.isActive = isActive;
    }


}
