package com.devandersen.usermanagementservice.dtos;

import lombok.Value;

@Value
public class UserValidationRequestDTO {

    String username;
    String password;
}
