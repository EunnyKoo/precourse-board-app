package com.example.precourseboardapp.react.dto;

import com.example.precourseboardapp.global.dto.BaseDto;
import com.example.precourseboardapp.react.entity.ReactBoard;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReactResponseDto extends BaseDto {
    private Long id;
    private String title;
    private String contents;
    private String author;
    private String password;
    public ReactResponseDto(LocalDateTime createdAt, LocalDateTime modifiedAt, ReactBoard reactBoard) {
        super(createdAt, modifiedAt);
        this.id = reactBoard.getId();
        this.title = reactBoard.getTitle();
        this.author = reactBoard.getAuthor();
        this.password = reactBoard.getPassword();
    }
}
