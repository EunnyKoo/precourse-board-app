package com.example.precourseboardapp.react.dto;

import com.example.precourseboardapp.global.dto.BaseDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReactResponseDto extends BaseDto {
    public ReactResponseDto(LocalDateTime createdAt, LocalDateTime modifiedAt) {
        super(createdAt, modifiedAt);
    }
}
