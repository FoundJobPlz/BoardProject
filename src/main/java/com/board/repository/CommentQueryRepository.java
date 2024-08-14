package com.board.repository;

import com.board.controller.dto.comment.CommentQueryDto;
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

    public CommentQueryDto findCommentReply(Long boardId,Long commentId) {

        CommentQueryDto result = findComment(boardId, commentId);
        result.putReplyList(findCommentAllReply(commentId));

        return result;
    }

    private CommentQueryDto findComment(Long boardId, Long commentId) {
        return em.createQuery(
                        "select new com.board.controller.dto.comment.CommentQueryDto(c.id, c.content, c.userId, c.boardEntity.id)" +
                                " from CommentEntity c" +
                                " where c.boardEntity.id =: boardId and c.id =: commentId", CommentQueryDto.class)
                .setParameter("commentId", commentId)
                .setParameter("boardId", boardId)
                .getSingleResult();
    }

    private List<GetCommentReplyResponseDto> findCommentAllReply(Long commentId) {
        return em.createQuery(
                        "select new com.board.controller.dto.comment.GetCommentReplyResponseDto(r.id, r.content, r.userId, r.commentEntity.id)" +
                                " from ReplyEntity r" +
                                " where r.commentEntity.id = :commentId", GetCommentReplyResponseDto.class)
                .setParameter("commentId", commentId)
                .getResultList();
    }

}
