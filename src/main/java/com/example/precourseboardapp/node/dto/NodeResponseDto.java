package com.example.precourseboardapp.node.dto;

import com.example.precourseboardapp.global.dto.BaseDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NodeResponseDto extends BaseDto {

    public NodeResponseDto(LocalDateTime createdAt, LocalDateTime modifiedAt) {
        super(createdAt, modifiedAt);
    }
}
