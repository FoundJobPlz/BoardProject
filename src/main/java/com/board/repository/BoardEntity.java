package com.board.repository;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
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

    public BoardEntity(Long id, String title, String content, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public BoardEntity() {

    }
}
