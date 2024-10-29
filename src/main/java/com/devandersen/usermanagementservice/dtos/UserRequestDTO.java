package com.devandersen.usermanagementservice.dtos;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class UserRequestDTO {

    String username;
    String password;
    String email;
}
