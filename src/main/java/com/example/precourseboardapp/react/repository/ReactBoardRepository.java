package com.example.precourseboardapp.react.repository;

import com.example.precourseboardapp.react.entity.ReactBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactBoardRepository extends JpaRepository<ReactBoard, Long> {
}
