package com.example.precourseboardapp.spring.service;

import com.example.precourseboardapp.spring.dto.SpringRequestDto;
import com.example.precourseboardapp.spring.dto.SpringResponseDto;
import com.example.precourseboardapp.spring.entity.SpringBoard;
import com.example.precourseboardapp.spring.repository.SpringBoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpringService {

    private final SpringBoardRepository springBoardRepository;

    public SpringService(SpringBoardRepository springBoardRepository) {
        this.springBoardRepository = springBoardRepository;
    }

    public List<SpringResponseDto> getPosts() {
        // DB에서 게시글 조회
        List<SpringResponseDto> responseDtoList = new ArrayList<>();
        List<SpringBoard> springBoardList = springBoardRepository.findAll();
        for (SpringBoard springBoard : springBoardList) {
            SpringResponseDto responseDto = new SpringResponseDto( springBoard);
            responseDtoList.add(responseDto);
        }
        return responseDtoList;
    }

    public SpringResponseDto getPost(Long id) {
         SpringBoard springBoard = springBoardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );
        return new SpringResponseDto(springBoard);
    }

    public SpringResponseDto savePost(SpringRequestDto requestDto) {
        SpringBoard springBoard = new SpringBoard(requestDto);

        return new SpringResponseDto(springBoardRepository.save(springBoard));
    }

    @Transactional
    public SpringResponseDto updatePost(Long id, SpringRequestDto requestDto) {
        SpringBoard springBoard = springBoardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );// 기존 데이터를 기록
        if (!requestDto.getPassword().equals(springBoard.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        springBoard.update(requestDto); // 변경할 데이터
        // 기존 데이터랑 변경된 데이터랑 비교해서 없데이트
        return new SpringResponseDto(springBoard);
    }

    public void deletePost(Long id) {
        SpringBoard springBoard = springBoardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );

        springBoardRepository.delete(springBoard);
    }
}
