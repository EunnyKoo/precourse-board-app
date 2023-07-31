package com.example.precourseboardapp.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BaseDto {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
