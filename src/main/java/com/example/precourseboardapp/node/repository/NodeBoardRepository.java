package com.example.precourseboardapp.node.repository;

import com.example.precourseboardapp.node.entity.NodeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeBoardRepository extends JpaRepository<NodeBoard, Long> {
}
