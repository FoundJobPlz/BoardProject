package com.board.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "comments")
public class CommentEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long Id;

    @Column(nullable = false, length = 500)
    @Setter
    private String content;

    @Column(nullable = false)
    @Setter
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

    public CommentEntity(String content, String userId, BoardEntity boardEntity) {
        this.content = content;
        this.userId = userId;
        this.boardEntity = boardEntity;
    }

    public CommentEntity() {
    }

    //연관관계 메서드
    private void setBoard(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
        boardEntity.getCommentEntity().add(this);
    }

    public void addComment(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
        boardEntity.getCommentEntity().add(this);
    }
}
