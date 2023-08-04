package com.example.precourseboardapp.node.dto;

import com.example.precourseboardapp.global.dto.BaseDto;
import com.example.precourseboardapp.node.entity.NodeBoard;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class NodeResponseDto extends BaseDto {
    private Long id;
    private String title;
    private String contents;
    private String author;
    private LocalDate date;

    public NodeResponseDto(NodeBoard nodeBoard) {
        super(nodeBoard.getCreatedAt(), nodeBoard.getModifiedAt());
        this.id = nodeBoard.getId();
        this.title = nodeBoard.getTitle();
        this.contents = nodeBoard.getContents();
        this.author = nodeBoard.getAuthor();
        this.date = nodeBoard.getModifiedAt().toLocalDate();
    }
}

