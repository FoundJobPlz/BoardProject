package com.board.repository;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 355)
    private String content;

    @Column(nullable = false, length = 30)
    private String userId;

    public BoardEntity(String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public BoardEntity() {

    }
}