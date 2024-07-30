package com.board.controller.dto;

import com.board.repository.BoardEntity;
import lombok.Data;
import lombok.Getter;

@Getter
public class ListCommentResponseDto {

    private Long id;
    private String content;
    private String userId;
    private Long boardId;

    public ListCommentResponseDto(Long id, String content, String userId, Long boardId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.boardId = boardId;
    }
}
