package com.example.precourseboardapp.react.service;

import com.example.precourseboardapp.react.dto.ReactRequestDto;
import com.example.precourseboardapp.react.dto.ReactResponseDto;
import com.example.precourseboardapp.react.entity.ReactBoard;
import com.example.precourseboardapp.react.repository.ReactBoardRepository;

import java.util.ArrayList;
import java.util.List;

public class ReactService {
    private final ReactBoardRepository reactBoardRepository;

    //초기화
    public ReactService(ReactBoardRepository reactBoardRepository) {
        this.reactBoardRepository = reactBoardRepository;
    }

    public List<ReactResponseDto> getPosts() {

        //DB에서 게시글 조회
        List<ReactResponseDto> responseDtoList = new ArrayList<>();
        List<ReactBoard> reactBoardList = reactBoardRepository.findAll();
        for(ReactBoard reactBoard : reactBoardList){
            ReactResponseDto responseDto = new ReactResponseDto(reactBoard.getCreatedAt(), reactBoard.getModifiedAt(), reactBoard);
            responseDtoList.add(responseDto);
        }

        return responseDtoList;
    }

    public ReactResponseDto getPost(Long id) {
        ReactBoard reactBoard = reactBoardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );
        //entity -> dto
        return new ReactResponseDto(reactBoard.getCreatedAt(), reactBoard.getModifiedAt(), reactBoard);
    }

    public ReactResponseDto savePost(ReactRequestDto requestDto) {
        //dto -> entity
        ReactBoard reactBoard = new ReactBoard(requestDto);
        //저장하는 내용이 담긴 entity 객체 1 -> DB의 1 row
        return new ReactResponseDto(reactBoard.getCreatedAt(), reactBoard.getModifiedAt(), reactBoardRepository.save(reactBoard));
    }
}
