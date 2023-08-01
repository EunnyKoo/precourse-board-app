package com.example.precourseboardapp.global.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

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

    @GetMapping("/spring/board/{id}")
    public ResponseDto getPost(@PathVariable Long id) {
        return ResponseDto.builder()
                .id(id)
                .title("title" + id)
                .contents("content" + id)
                .author("Robbie" + id)
                .password("1234")
                .date(LocalDate.of(2023, 1, 11))
                .build();
    }

    @GetMapping("/spring/board")
    public List<ResponseDto> getBoardList() {
        LocalDateTime of = LocalDateTime.of(2023, 1, 11, 10, 10);
        LocalDate ld = LocalDate.of(of.getYear(), of.getMonth(), of.getDayOfMonth());
        return List.of(
                ResponseDto.builder()
                        .id(1L)
                        .title("title1")
                        .contents("content1")
                        .author("Robbie1")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(2L)
                        .title("title2")
                        .contents("content2")
                        .author("Robbie2")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(3L)
                        .title("title3")
                        .contents("content3")
                        .author("Robbie3")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(4L)
                        .title("title4")
                        .contents("content4")
                        .author("Robbie4")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(5L)
                        .title("title5")
                        .contents("content5")
                        .author("Robbie5")
                        .password("12345")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(6L)
                        .title("title6")
                        .contents("content6")
                        .author("Robbie6")
                        .password("12346")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(7L)
                        .title("title7")
                        .contents("content7")
                        .author("Robbie7")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(8L)
                        .title("title8")
                        .contents("content8")
                        .author("Robbie8")
                        .password("12347")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(9L)
                        .title("title8")
                        .contents("content9")
                        .author("Robbie9")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(10L)
                        .title("title10")
                        .contents("content10")
                        .author("Robbie10")
                        .password("1234")
                        .date(ld)
                        .build(),
                ResponseDto.builder()
                        .id(11L)
                        .title("title11")
                        .contents("content11")
                        .author("Robbie11")
                        .password("1234")
                        .date(ld)
                        .build()
        );
    }

    @PostMapping("/spring/board")
    public String savePost(@RequestBody RequestDto requestDto) {
        System.out.println(requestDto.toString());
        return "success";
    }

    @PutMapping("/spring/board/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        if ("1234".equals(requestDto.getPassword())) return "success";
        else return "fail";
    }

    @DeleteMapping("/spring/board/{id}")
    public String deletePost(@PathVariable Long id) {
        return "success";
    }
}
