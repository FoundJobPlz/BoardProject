package com.board.controller.dto;

import com.board.repository.BoardEntity;
import com.board.repository.CommentEntity;
import lombok.Data;

@Data
public class CreateCommentRequestDto {

    private String content;
    private String userId;
    private Long boardId;

    public CreateCommentRequestDto(String content, String userId, Long boardId) {
        this.content = content;
        this.userId = userId;
        this.boardId = boardId;
    }
}
