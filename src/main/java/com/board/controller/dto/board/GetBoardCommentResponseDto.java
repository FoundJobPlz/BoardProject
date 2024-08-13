package com.board.controller.dto.board;

import com.board.controller.dto.comment.CommentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetBoardCommentResponseDto {

    private Long boardId;
    private String title;
    private String content;
    private String userId;

    List<CommentDto> commentList;

    @Builder
    public GetBoardCommentResponseDto(Long boardId, String title, String content, String userId, List<CommentDto> commentList) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.commentList = commentList;
    }
}
