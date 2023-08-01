package com.example.precourseboardapp.react.entity;


import com.example.precourseboardapp.global.entity.Timestamped;
import com.example.precourseboardapp.react.dto.ReactRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class ReactBoard extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String password;
    @Column(length = 2000)
    private String contents;

    public ReactBoard(ReactRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }
}
