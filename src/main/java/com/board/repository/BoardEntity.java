package com.board.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Setter
    @Column(nullable = false, length = 50)
    private String title;

    @Setter
    @Column(nullable = false, length = 355)
    private String content;

    @Column(nullable = false, length = 30)
    private String userId;

    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> commentEntity = new ArrayList<>();

    public BoardEntity(String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public BoardEntity() {

    }
}