package com.imanol.Auth.controllers.impl;

import com.imanol.Auth.commons.dtos.AuthResponseDto;
import com.imanol.Auth.commons.dtos.LoginRequestDto;
import com.imanol.Auth.commons.dtos.RegisterRequestDto;
import com.imanol.Auth.commons.dtos.TokenResponse;
import com.imanol.Auth.controllers.AuthApi;
import com.imanol.Auth.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

    private final AuthService authService;

    AuthController(AuthService authService){
        this.authService = authService;
    }


    @Override
    public ResponseEntity<TokenResponse> createUser(RegisterRequestDto registerRequestDto) {
        return ResponseEntity.ok(authService.createUser(registerRequestDto));
    }

    @Override
    public ResponseEntity<TokenResponse> loginUser(LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.loginUser(loginRequestDto));
    }
}
