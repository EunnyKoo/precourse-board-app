package com.example.precourseboardapp.auth.entity;

import com.example.precourseboardapp.auth.dto.SignupRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String author;
    private String password;
    private String email;
    private String phoneNumber;

    public User(SignupRequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.email = requestDto.getEmail();
        this.phoneNumber = requestDto.getPhone();
    }
}
