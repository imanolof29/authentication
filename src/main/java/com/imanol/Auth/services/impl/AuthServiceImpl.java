package com.imanol.Auth.services.impl;

import com.imanol.Auth.commons.dtos.LoginRequestDto;
import com.imanol.Auth.commons.dtos.RegisterRequestDto;
import com.imanol.Auth.commons.dtos.TokenResponse;
import com.imanol.Auth.commons.entities.User;
import com.imanol.Auth.repositories.UserRepository;
import com.imanol.Auth.services.AuthService;
import com.imanol.Auth.services.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    AuthServiceImpl(UserRepository userRepository, JwtService jwtService){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }


    @Override
    public TokenResponse createUser(RegisterRequestDto registerRequestDto) {
        return Optional.of(registerRequestDto)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    @Override
    public TokenResponse loginUser(LoginRequestDto loginRequestDto) {
        return Optional.of(loginRequestDto)
                .map(request -> authenticateUser(request.getEmail(), request.getPassword()))
                .map(user -> jwtService.generateToken(user.getId()))
                .orElseThrow(() -> new RuntimeException("Error logging user"));


    }

    private User authenticateUser(String email, String password) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    if (user.getPassword().equals(password)) {
                        return user;
                    } else {
                        throw new IllegalArgumentException("Invalid password");
                    }
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private User mapToEntity(RegisterRequestDto registerRequestDto){
        return User.builder()
                .email(registerRequestDto.getEmail())
                .fullName(registerRequestDto.getFullName())
                .build();
    }

}