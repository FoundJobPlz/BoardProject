package com.board.repository;

import com.board.controller.dto.board.GetBoardCommentResponseDto;
import com.board.controller.dto.comment.CommentDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepository {

    private final EntityManager em;

    public GetBoardCommentResponseDto findBoardComments(Long boardId) {

        List<CommentEntity> commentEntities = em.createQuery(
                        "select c" +
                                " from CommentEntity c" +
                                " where c.boardEntity.id = :boardId", CommentEntity.class)
                .setParameter("boardId", boardId)
                .getResultList();

        BoardEntity boardEntity = em.createQuery(
                        "select b" +
                                " from BoardEntity b" +
                                " where b.id = :boardId", BoardEntity.class)
                .setParameter("boardId", boardId)
                .getSingleResult();

        List<CommentDto> commentDtos = commentEntities.stream().map(
                commentEntity -> CommentDto.builder()
                        .id(commentEntity.getId())
                        .content(commentEntity.getContent())
                        .userId(commentEntity.getUserId())
                        .boardId(commentEntity.getBoardEntity().getId()).build()).toList();

        return GetBoardCommentResponseDto.builder()
                .boardId(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .userId(boardEntity.getUserId())
                .commentList(commentDtos)
                .build();
    }
}
