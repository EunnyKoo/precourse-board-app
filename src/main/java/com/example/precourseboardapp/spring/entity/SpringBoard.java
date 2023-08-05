package com.example.precourseboardapp.spring.entity;


import com.example.precourseboardapp.auth.entity.User;
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
    @Column(length = 2000)
    private String contents;

    @ManyToOne
    private User user; // user_id

    public SpringBoard(SpringRequestDto springRequestDto, User user) {
        this.title = springRequestDto.getTitle();
        this.contents = springRequestDto.getContents();
        this.user = user;
    }

    public void update(SpringRequestDto springRequestDto) {
        this.title = springRequestDto.getTitle();
        this.contents = springRequestDto.getContents();
    }
}
