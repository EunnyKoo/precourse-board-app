package com.example.precourseboardapp.react.controller;

import com.example.precourseboardapp.react.dto.ReactRequestDto;
import com.example.precourseboardapp.react.dto.ReactResponseDto;
import com.example.precourseboardapp.react.service.ReactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/react")
public class ReactController {//HTTP 요청을 받는 클래스
    private final ReactService reactService;

    //초기화
    public ReactController(ReactService reactService) {
        this.reactService = reactService;
    }

    //게시글 목록 조회 : GET
    @GetMapping("/board")
    public List<ReactResponseDto> getPosts() {//게시글 반환 -> DB
        return reactService.getPosts();
    }

    //게시글 상세 조회 : GET
    @GetMapping("/board/{id}")
    public ReactResponseDto getPost(@PathVariable Long id) {//게시글 반환 -> DB
        return reactService.getPost(id);
    }

    //게시글 생성 : POST
    @PostMapping("/board")
    public String savePost(@RequestBody ReactRequestDto requestDto){
        reactService.savePost(requestDto);

        return "success";
    }

    //게시글 수정 : PUT
    @PutMapping("/board/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody ReactRequestDto requestDto) {
        reactService.updatePost(id, requestDto);

        return "success";
    }

    //게시글 삭제 : DELETE
    @DeleteMapping("/board/{id}")
    public String deletePost(@PathVariable Long id) {
        reactService.deletePost(id);

        return "success";
    }
}
