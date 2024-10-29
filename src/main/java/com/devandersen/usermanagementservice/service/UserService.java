package com.devandersen.usermanagementservice.service;

import com.devandersen.usermanagementservice.dtos.UserRequestDTO;
import com.devandersen.usermanagementservice.dtos.UserValidationRequestDTO;
import com.devandersen.usermanagementservice.dtos.UserValidationResponseDTO;
import com.devandersen.usermanagementservice.mappers.UserMapper;
import com.devandersen.usermanagementservice.model.User;
import com.devandersen.usermanagementservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserValidationResponseDTO validateUser(UserValidationRequestDTO userValidationRequestDTO){
        Optional<User> userOptional = userRepository.findByUsername(userValidationRequestDTO.getUsername());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return new UserValidationResponseDTO(user.getPassword().equals(userValidationRequestDTO.getPassword()));
        }else{
            return new UserValidationResponseDTO(false);
        }
    }

    public void createUser(UserRequestDTO userRequestDTO){

       User user = UserMapper.INSTANCE.userRequestDTOToUser(userRequestDTO);
       userRepository.save(user);
    }
}
