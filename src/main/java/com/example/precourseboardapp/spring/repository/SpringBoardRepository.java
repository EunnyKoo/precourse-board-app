package com.example.precourseboardapp.spring.repository;

import com.example.precourseboardapp.spring.entity.SpringBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringBoardRepository extends JpaRepository<SpringBoard, Long> {
}
