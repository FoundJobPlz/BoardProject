package com.board.repository;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "reply")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyEntity extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "reply_id")
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private CommentEntity commentEntity;

    @Builder
    public ReplyEntity(String content, String userId, CommentEntity commentEntity) {
        this.content = content;
        this.userId = userId;
        this.commentEntity = commentEntity;
    }

    public void updateReply(String content) {
        this.content = content;
    }
}
