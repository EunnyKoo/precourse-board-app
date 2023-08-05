package com.example.precourseboardapp.auth.repository;

import com.example.precourseboardapp.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAuthor(String author);
}
