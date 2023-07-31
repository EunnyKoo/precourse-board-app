package com.example.precourseboardapp.spring.dto;

import com.example.precourseboardapp.global.dto.BaseDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SpringResponseDto extends BaseDto {
    public SpringResponseDto(LocalDateTime createdAt, LocalDateTime modifiedAt) {
        super(createdAt, modifiedAt);
    }
}
