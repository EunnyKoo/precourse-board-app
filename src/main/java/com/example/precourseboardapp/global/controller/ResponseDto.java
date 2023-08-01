package com.example.precourseboardapp.global.controller;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String author;
    private String password;
    private LocalDate date;

    @Builder
    public ResponseDto(Long id, String title, String contents, String author, String password, LocalDate date) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.password = password;
        this.date = date;
    }
}
