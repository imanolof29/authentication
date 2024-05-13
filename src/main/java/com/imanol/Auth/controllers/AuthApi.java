package com.imanol.Auth.controllers;

import com.imanol.Auth.commons.constants.ApiPathConstants;
import com.imanol.Auth.commons.dtos.LoginRequestDto;
import com.imanol.Auth.commons.dtos.RegisterRequestDto;
import com.imanol.Auth.commons.dtos.TokenResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface AuthApi {
    @PostMapping("/register")
    ResponseEntity<TokenResponse> createUser(@RequestBody @Valid RegisterRequestDto registerRequestDto);

    @PostMapping("/login")
    ResponseEntity<TokenResponse> loginUser(@RequestBody @Valid LoginRequestDto loginRequestDto);
}
