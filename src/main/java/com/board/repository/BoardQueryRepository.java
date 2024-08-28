package com.board.repository;

import com.board.controller.dto.board.BoardDto;
import com.board.controller.dto.board.BoardQueryDto;
import com.board.controller.dto.board.GetBoardCommentResponseDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepository {

    private final EntityManager em;

    public BoardQueryDto findBoardComments(Long boardId) {

        BoardQueryDto result = findBoard(boardId);
        result.putComments(findBoardAllComment(boardId));

        return result;
    }

    private BoardQueryDto findBoard(Long boardId) {
        return em.createQuery(
                        "select new com.board.controller.dto.board.BoardQueryDto(b.id, b.title, b.content, b.userId, b.createdBy, b.lastModifiedDate, b.createdDate)" +
                                " from BoardEntity b" +
                                " where b.id = :boardId", BoardQueryDto.class)
                .setParameter("boardId", boardId)
                .getSingleResult();
    }

    private List<GetBoardCommentResponseDto> findBoardAllComment(Long boardId) {
        return em.createQuery(
                        "select new com.board.controller.dto.board.GetBoardCommentResponseDto(c.id, c.content, c.userId, c.boardEntity.id)" +
                                " from CommentEntity c" +
                                " where c.boardEntity.id = : boardId", GetBoardCommentResponseDto.class)
                .setParameter("boardId", boardId)
                .getResultList();
    }
}
