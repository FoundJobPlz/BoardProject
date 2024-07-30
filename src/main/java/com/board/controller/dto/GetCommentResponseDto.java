package com.board.controller.dto;

import com.board.repository.BoardEntity;
import lombok.Data;

@Data
public class GetCommentResponseDto {

    private Long id;
    private String content;
    private String userId;
    private Long boardId;

    public GetCommentResponseDto(Long id, String content, String userId, Long boardId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.boardId = boardId;
    }
}
