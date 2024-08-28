package com.board.repository;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long Id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

    @OneToMany(mappedBy = "commentEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReplyEntity> replyEntities =  new ArrayList<>();

    @Builder
    public CommentEntity(String content, String userId, BoardEntity boardEntity) {
        this.content = content;
        this.userId = userId;
        this.boardEntity = boardEntity;
    }

    public void updateContent(String content) {
        this.content = content;
    }


    //연관관계 메서드
    private void updateBoard(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
        boardEntity.getCommentEntities().add(this);
    }

    public void addComment(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
        boardEntity.getCommentEntities().add(this);
    }
}
