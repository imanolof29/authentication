package com.imanol.Auth.commons.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegisterRequestDto {

    @NotNull
    private String fullName;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

}
