package com.example.precourseboardapp.react.controller;

import com.example.precourseboardapp.react.dto.ReactRequestDto;
import com.example.precourseboardapp.react.dto.ReactResponseDto;
import com.example.precourseboardapp.react.service.ReactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reactBoard")
public class ReactController {//HTTP 요청을 받는 클래스
    private final ReactService reactService;

    //초기화
    public ReactController(ReactService reactService) {
        this.reactService = reactService;
    }

    //게시글 목록 조회 : GET
    @GetMapping("/list")
    public List<ReactResponseDto> getPosts() {//게시글 반환 -> DB
        return reactService.getPosts();
    }

    //게시글 상세 조회 : GET
    @GetMapping("/detail/{id}")
    public ReactResponseDto getPost(@PathVariable Long id) {//게시글 반환 -> DB
        return reactService.getPost(id);
    }

    //게시글 생성 : POST
    @PostMapping("/insert")
    public ReactResponseDto savePost(@RequestBody ReactRequestDto requestDto){
        return reactService.savePost(requestDto);
    }
}
