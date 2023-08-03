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
    public ResponseEntity<?> getPosts() {//게시글 반환 -> DB
        if (reactService.getPosts() == null) {
            return notFound().build();
        }
        return ResponseEntity.ok(reactService.getPosts());
    }

    //게시글 상세 조회 : GET
    @GetMapping("/board/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {//게시글 반환 -> DB
        if (id == null) {
            return notFound().build();
        }
        return ResponseEntity.ok(reactService.getPost(id));
    }

    //게시글 생성 : POST
    @PostMapping("/board")
    public ResponseEntity<?> savePost(@RequestBody ReactRequestDto requestDto){
        if (requestDto == null) {
            return notFound().build();
        }
        return ResponseEntity.ok(reactService.savePost(requestDto));
    }

    //게시글 수정 : PUT
    @PutMapping("/board/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody ReactRequestDto requestDto) {
        if (id == null) {
            return notFound().build();
        }
        return ResponseEntity.ok(reactService.updatePost(id, requestDto));
    }

    //게시글 삭제 : DELETE
    @DeleteMapping("/board/{id}")
    public void deletePost(@PathVariable Long id) {
        if (id == null) {
            notFound().build();
        }
        else
            reactService.deletePost(id);
    }
}
