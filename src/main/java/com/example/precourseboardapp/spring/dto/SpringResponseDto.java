package com.example.precourseboardapp.spring.dto;

import com.example.precourseboardapp.global.dto.BaseDto;
import com.example.precourseboardapp.spring.entity.SpringBoard;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SpringResponseDto extends BaseDto {

    private Long id;
    private String title;
    private String contents;
    private String author;
    private LocalDate date;

    public SpringResponseDto(SpringBoard springBoard) {
        super(springBoard.getCreatedAt(), springBoard.getModifiedAt());
        this.id = springBoard.getId();
        this.title = springBoard.getTitle();
        this.author = springBoard.getUser().getAuthor();
        this.contents = springBoard.getContents();
        this.date = springBoard.getModifiedAt().toLocalDate();
    }
}
