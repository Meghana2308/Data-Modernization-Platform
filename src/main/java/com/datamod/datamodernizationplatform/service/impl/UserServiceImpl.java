package com.datamod.datamodernizationplatform.service.impl;

import com.datamod.datamodernizationplatform.dto.request.UserRequestDTO;
import com.datamod.datamodernizationplatform.dto.responce.UserResponseDTO;
import com.datamod.datamodernizationplatform.model.User;
import com.datamod.datamodernizationplatform.repository.UserRepository;
import com.datamod.datamodernizationplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setAge(request.getAge());
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setId(savedUser.getId());
        response.setFullName(savedUser.getFirstName() + " " + savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());

        return response;
    }
}
