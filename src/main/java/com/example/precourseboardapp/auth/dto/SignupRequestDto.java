package com.example.precourseboardapp.auth.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String author;
    private String password;
    private String email;
    private String phone;
}

