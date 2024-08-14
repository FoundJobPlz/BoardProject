package com.board.controller.dto.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetBoardCommentResponseDto {

    private Long commentId;
    private String content;
    private String userId;
    private Long boardId;

    public GetBoardCommentResponseDto(Long commentId, String content, String userId, Long boardId) {
        this.commentId = commentId;
        this.content = content;
        this.userId = userId;
        this.boardId = boardId;
    }
}
