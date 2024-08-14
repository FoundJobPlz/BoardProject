package com.board.controller.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CommentQueryDto {

    private Long id;
    private String content;
    private String userId;
    private Long boardId;
    private List<GetCommentReplyResponseDto> replyList;

    public CommentQueryDto(Long id, String content, String userId, Long boardId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.boardId = boardId;
    }

    public void putReplyList(List<GetCommentReplyResponseDto> replyList) {
        this.replyList = replyList;
    }
}
