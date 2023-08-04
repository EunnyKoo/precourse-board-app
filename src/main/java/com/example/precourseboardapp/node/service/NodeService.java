package com.example.precourseboardapp.node.service;

import com.example.precourseboardapp.node.dto.NodeRequestDto;
import com.example.precourseboardapp.node.dto.NodeResponseDto;
import com.example.precourseboardapp.node.entity.NodeBoard;
import com.example.precourseboardapp.node.repository.NodeBoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NodeService {

    private NodeBoardRepository nodeBoardRepository;

    public NodeService(NodeBoardRepository nodeBoardRepository) {
        this.nodeBoardRepository = nodeBoardRepository;
    }

    public List<NodeResponseDto> getPosts() {
        List<NodeResponseDto> responseDtoList = new ArrayList<>();

        List<NodeBoard> nodeBoardList = nodeBoardRepository.findAll();
        for (NodeBoard nodeBoard : nodeBoardList) {
            NodeResponseDto responseDto = new NodeResponseDto(nodeBoard);
            responseDtoList.add(responseDto);
        }

        return responseDtoList;
    }

    public NodeResponseDto getPost(Long id) {
        NodeBoard nodeBoard = nodeBoardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );
        return new NodeResponseDto(nodeBoard);
    }

    public NodeBoard savePost(NodeRequestDto requestDto) {
        NodeBoard nodeBoard = new NodeBoard(requestDto);
        return nodeBoardRepository.save(nodeBoard);
    }

    @Transactional
    public NodeBoard updatePost(Long id, NodeRequestDto requestDto) {
        NodeBoard nodeBoard = nodeBoardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );
        //비밀번호!
        // 게시글 정보 업데이트
        nodeBoard.update(requestDto);
        return nodeBoardRepository.save(nodeBoard);
    }

    public void deletePost(Long id) {
        NodeBoard nodeBoard = nodeBoardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );
        nodeBoardRepository.delete(nodeBoard);
    }
}