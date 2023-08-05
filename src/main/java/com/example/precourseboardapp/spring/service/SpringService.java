package com.example.precourseboardapp.spring.service;

import com.example.precourseboardapp.auth.entity.User;
import com.example.precourseboardapp.auth.jwt.JwtUtil;
import com.example.precourseboardapp.auth.repository.UserRepository;
import com.example.precourseboardapp.spring.dto.SpringRequestDto;
import com.example.precourseboardapp.spring.dto.SpringResponseDto;
import com.example.precourseboardapp.spring.entity.SpringBoard;
import com.example.precourseboardapp.spring.repository.SpringBoardRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SpringService {

    private final SpringBoardRepository springBoardRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public List<SpringResponseDto> getPosts() {

        List<SpringResponseDto> responseDtoList = new ArrayList<>();

        List<SpringBoard> springBoardList = springBoardRepository.findAll();
        for (SpringBoard springBoard : springBoardList) {
            SpringResponseDto responseDto = new SpringResponseDto(springBoard);
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

    public void savePost(SpringRequestDto requestDto, String accessToken) {

        if (!jwtUtil.validateToken(accessToken)) {
            throw new IllegalArgumentException("Token Err");
        }

        User user = getUserByToken(accessToken);

        if(Objects.isNull(user)) {
            throw new NullPointerException("해당 사용자는 존재하지 않습니다.");
        }

        SpringBoard springBoard = new SpringBoard(requestDto, user);
        springBoardRepository.save(springBoard);
    }

    @Transactional
    public void updatePost(Long id, SpringRequestDto requestDto, String accessToken) {

        if (!jwtUtil.validateToken(accessToken)) {
            throw new IllegalArgumentException("Token Err");
        }

        User user = getUserByToken(accessToken);

        SpringBoard springBoard = getBoardByIdAndUser(id, user);
        springBoard.update(requestDto); // 변경할 데이터
        // 기존 데이터랑 변경된 데이터랑 비교해서 업데이트
    }

    public void deletePost(Long id, String accessToken) {

        if (!jwtUtil.validateToken(accessToken)) {
            throw new IllegalArgumentException("Token Err");
        }

        User user = getUserByToken(accessToken);

        SpringBoard springBoard = getBoardByIdAndUser(id, user);
        springBoardRepository.delete(springBoard);
    }

    private User getUserByToken(String accessToken) {
        Claims info = jwtUtil.getUserInfoFromToken(accessToken);
        return userRepository.findByAuthor(info.getSubject()).orElse(null);
    }

    private SpringBoard getBoardByIdAndUser(Long id, User user) {
        return springBoardRepository.findByIdAndUser(id, user).orElseThrow(
                () -> new NullPointerException("해당 사용자가 작성한 게시글이 아닙니다.")
        );
    }
}
