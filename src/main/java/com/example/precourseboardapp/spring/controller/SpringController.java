package com.example.precourseboardapp.spring.controller;

import com.example.precourseboardapp.global.controller.ResponseDto;
import com.example.precourseboardapp.spring.dto.SpringRequestDto;
import com.example.precourseboardapp.spring.dto.SpringResponseDto;
import com.example.precourseboardapp.spring.entity.SpringBoard;
import com.example.precourseboardapp.spring.service.SpringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/spring")
public class SpringController {//http 요청 받는 클래스
    private final SpringService springService;
    //초기화
    public SpringController(SpringService springService) {
        this.springService = springService;
    }

    //게시글 목록 조회 : GET
    @GetMapping("/board")
    public List<SpringResponseDto> getPosts() {
        //게시글 반환 -> DB
        return springService.getPosts();
    }

    //게시글 상세 조회 : GET
    @GetMapping("/board/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {//게시글 반환 -> DB
        return ResponseEntity.ok(springService.getPost(id));
    }

    // 게시글 등록 : POST
    @PostMapping("/board")
    public String savePost(@RequestBody SpringRequestDto requestDto) {
        springService.savePost(requestDto);
        return "success";
    }

    // 게시글 수정 : PUT
    @PutMapping("/board/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody SpringRequestDto springRequestDto) {
        springService.updatePost(id, springRequestDto);
        return "success";
    }

    // 게시글 삭제 : DELETE
    @DeleteMapping("/board/{id}")
    public String deletePost(@PathVariable Long id) {
        springService.deletePost(id);
        return "success";
    }
}

