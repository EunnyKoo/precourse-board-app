package com.example.precourseboardapp.global.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HealthCheckController {
    @GetMapping("/ping")
     public String ping() {
        return "OK";
    }

    @GetMapping("/test/board")
    public List<ResponseDto> getBoardList() {
        LocalDateTime of = LocalDateTime.of(2023, 1, 11, 10, 10);
        LocalDate ld = LocalDate.of(of.getYear(), of.getMonth(), of.getDayOfMonth());
        return List.of(
                ResponseDto.builder()
                        .id(1L)
                        .title("titl1")
                        .contents("content1")
                        .author("Robbie1")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(2L)
                        .title("titl2")
                        .contents("content2")
                        .author("Robbie2")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(3L)
                        .title("titl3")
                        .contents("content3")
                        .author("Robbie3")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(4L)
                        .title("titl4")
                        .contents("content4")
                        .author("Robbie4")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(5L)
                        .title("titl5")
                        .contents("content5")
                        .author("Robbie5")
                        .password("12345")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(6L)
                        .title("titl6")
                        .contents("content6")
                        .author("Robbie6")
                        .password("12346")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(7L)
                        .title("titl7")
                        .contents("content7")
                        .author("Robbie7")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(8L)
                        .title("titl8")
                        .contents("content8")
                        .author("Robbie8")
                        .password("12347")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(9L)
                        .title("titl8")
                        .contents("content9")
                        .author("Robbie9")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(10L)
                        .title("titl10")
                        .contents("content10")
                        .author("Robbie10")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(11L)
                        .title("titl11")
                        .contents("content11")
                        .author("Robbie11")
                        .password("1234")
                        .date(ld)
                        .build()
        );
    }
}
