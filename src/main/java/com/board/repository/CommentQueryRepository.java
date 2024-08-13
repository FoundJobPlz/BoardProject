package com.board.repository;

import com.board.controller.dto.comment.GetCommentReplyResponseDto;
import com.board.controller.dto.reply.ReplyDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentQueryRepository {

    private final EntityManager em;

    public GetCommentReplyResponseDto findCommentReply(Long commentId) {

        CommentEntity commentEntity = em.createQuery(
                        "select c" +
                                " from CommentEntity c" +
                                " where c.id = :commentId", CommentEntity.class)
                .setParameter("commentId", commentId)
                .getSingleResult();

        List<ReplyEntity> resultEntityList = em.createQuery(
                        "select r" +
                                " from ReplyEntity r" +
                                " where r.commentEntity.id = :commentId", ReplyEntity.class)
                .setParameter("commentId", commentId)
                .getResultList();

        List<ReplyDto> replyDtos = resultEntityList.stream().map(
                replyEntity -> ReplyDto.builder()
                        .id(replyEntity.getId())
                        .content(replyEntity.getContent())
                        .userId(replyEntity.getUserId())
                        .commentId(replyEntity.getCommentEntity().getId())
                        .build()).toList();

        return GetCommentReplyResponseDto.builder()
                .commentId(commentId)
                .content(commentEntity.getContent())
                .userId(commentEntity.getUserId())
                .replies(replyDtos).build();
    }

}
