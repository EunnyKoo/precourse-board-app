package com.example.precourseboardapp.spring.entity;


import com.example.precourseboardapp.global.entity.Timestamped;
import com.example.precourseboardapp.spring.dto.SpringRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class SpringBoard extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String password;
    @Column(length = 2000)
    private String contents;

    public SpringBoard(SpringRequestDto springRequestDto) {
        this.title = springRequestDto.getTitle();
        this.author = springRequestDto.getAuthor();
        this.password = springRequestDto.getPassword();
        this.contents = springRequestDto.getContents();
    }

    public void update(SpringRequestDto springRequestDto) {
        this.title = springRequestDto.getTitle();
        this.author = springRequestDto.getAuthor();
        this.password = springRequestDto.getPassword();
        this.contents = springRequestDto.getContents();
    }
}
