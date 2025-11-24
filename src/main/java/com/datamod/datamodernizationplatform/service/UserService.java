package com.datamod.datamodernizationplatform.service;

import com.datamod.datamodernizationplatform.dto.request.UserRequestDTO;
import com.datamod.datamodernizationplatform.dto.responce.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO request);
}

