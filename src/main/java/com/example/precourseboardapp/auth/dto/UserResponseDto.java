package com.example.precourseboardapp.auth.dto;

import com.example.precourseboardapp.auth.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String author;
    private String email;
    private String phone;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.author = user.getAuthor();
        this.email = user.getEmail();
        this.phone = user.getPhoneNumber();
    }
}
