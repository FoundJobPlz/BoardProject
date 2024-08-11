package com.board.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String content;
    private String userId;
    private Long boardId;

    @Builder
    public CommentDto(Long id, String content, String userId, Long boardId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.boardId = boardId;
    }
}
