package com.example.precourseboardapp.global.controller;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class RequestDto {
    private String title;
    private String contents;
    private String author;
    private String password;
}
