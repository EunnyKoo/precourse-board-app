package com.example.precourseboardapp.spring.repository;

import com.example.precourseboardapp.auth.entity.User;
import com.example.precourseboardapp.spring.entity.SpringBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringBoardRepository extends JpaRepository<SpringBoard, Long> {
    Optional<SpringBoard> findByIdAndUser(Long id, User user);
    // select * from spring_board where id = ? and user_id = ?;
}
