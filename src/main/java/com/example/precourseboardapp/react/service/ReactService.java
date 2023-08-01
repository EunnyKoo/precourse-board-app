package com.example.precourseboardapp.react.service;

import com.example.precourseboardapp.react.dto.ReactRequestDto;
import com.example.precourseboardapp.react.dto.ReactResponseDto;
import com.example.precourseboardapp.react.entity.ReactBoard;
import com.example.precourseboardapp.react.repository.ReactBoardRepository;
import jakarta.transaction.Transactional;

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

    @Transactional
    public ReactResponseDto updatePost(Long id, ReactRequestDto requestDto) {
        //받아온 post id로 DB에 해당하는 1row를 가져온다 -> entity
        ReactBoard reactBoard = reactBoardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );

        //DB에서 가져온 게시글 비밀번호와 수정하려고 요청받은 비밀번호의 일치 여부 확인
        if(!requestDto.getPassword().equals(reactBoard.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }

        reactBoard.update(requestDto);

        return new ReactResponseDto(reactBoard.getCreatedAt(), reactBoard.getModifiedAt(), reactBoard);
    }

    public void deletePost(Long id) {

        //받아온 post id로 DB에 해당하는 1row를 가져온다 -> entity
        ReactBoard reactBoard = reactBoardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );

        reactBoardRepository.delete(reactBoard);
    }
}
