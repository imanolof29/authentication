package com.imanol.Auth.services;

import com.imanol.Auth.commons.dtos.AuthResponseDto;
import com.imanol.Auth.commons.dtos.LoginRequestDto;
import com.imanol.Auth.commons.dtos.RegisterRequestDto;
import com.imanol.Auth.commons.dtos.TokenResponse;

public interface AuthService {

    TokenResponse createUser(RegisterRequestDto registerRequestDto);

    TokenResponse loginUser(LoginRequestDto loginRequestDto);

}
