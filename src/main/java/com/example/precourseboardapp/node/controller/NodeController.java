package com.example.precourseboardapp.node.controller;

import com.example.precourseboardapp.node.dto.NodeRequestDto;
import com.example.precourseboardapp.node.dto.NodeResponseDto;
import com.example.precourseboardapp.node.service.NodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/node")
public class NodeController {

    private NodeService nodeService;

    public NodeController(NodeService nodeService){
        this.nodeService = nodeService;
    }

    @GetMapping("/board")
    public List<NodeResponseDto> getPosts(){
        return nodeService.getPosts();
    }

    @GetMapping("/board/{id}")
    public NodeResponseDto getPost(@PathVariable Long id) {
        return nodeService.getPost(id);
    }

    @PostMapping ("/board")
    public String savePost(@RequestBody NodeRequestDto requestDto){
        nodeService.savePost(requestDto);
        return "success";
    }

    @PutMapping("/board/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody NodeRequestDto requestDto){
        nodeService.updatePost(id, requestDto);
        return "success";
    }

    @DeleteMapping("/board/{id}")
    public String deletePost(@PathVariable Long id) {
        nodeService.deletePost(id);
        return "success";
    }
}