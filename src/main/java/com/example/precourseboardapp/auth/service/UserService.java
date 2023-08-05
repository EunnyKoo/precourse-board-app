package com.example.precourseboardapp.auth.service;

import com.example.precourseboardapp.auth.dto.LoginRequestDto;
import com.example.precourseboardapp.auth.dto.SignupRequestDto;
import com.example.precourseboardapp.auth.dto.UserResponseDto;
import com.example.precourseboardapp.auth.entity.User;
import com.example.precourseboardapp.auth.jwt.JwtUtil;
import com.example.precourseboardapp.auth.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public UserResponseDto login(LoginRequestDto requestDto, HttpServletResponse response) {

        User user = userRepository.findByAuthor(requestDto.getAuthor()).orElseThrow(() ->
                new NullPointerException("해당 사용자는 존재하지 않습니다.")
        );

        if (!user.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getAuthor()));

        return new UserResponseDto(user);
    }

    public String signup(SignupRequestDto requestDto) {

        User user = new User(requestDto);
        userRepository.save(user);

        return "success";
    }
}
