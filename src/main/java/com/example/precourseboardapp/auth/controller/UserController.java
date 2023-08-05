package com.example.precourseboardapp.auth.controller;

import com.example.precourseboardapp.auth.dto.LoginRequestDto;
import com.example.precourseboardapp.auth.dto.SignupRequestDto;
import com.example.precourseboardapp.auth.dto.UserResponseDto;
import com.example.precourseboardapp.auth.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public UserResponseDto login(@RequestBody LoginRequestDto requestDto, HttpServletResponse response) {
        return userService.login(requestDto, response);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequestDto requestDto) {
        return userService.signup(requestDto);
    }
}
