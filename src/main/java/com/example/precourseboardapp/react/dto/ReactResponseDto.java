package com.example.precourseboardapp.react.dto;

import com.example.precourseboardapp.global.dto.BaseDto;
import com.example.precourseboardapp.react.entity.ReactBoard;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ReactResponseDto extends BaseDto {
    private Long id;
    private String title;
    private String contents;
    private String author;
    private LocalDate date;


    public ReactResponseDto(ReactBoard reactBoard) {
        super(reactBoard.getCreatedAt(), reactBoard.getModifiedAt());
        this.id = reactBoard.getId();
        this.title = reactBoard.getTitle();
        this.contents = reactBoard.getContents();
        this.author = reactBoard.getAuthor();
        this.date = reactBoard.getModifiedAt().toLocalDate();
    }
}
