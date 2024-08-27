package com.board.controller.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class GetCommentReplyResponseDto {

    private Long replyId;
    private String content;
    private String userId;
    private Long commentId;


    public GetCommentReplyResponseDto(Long replyId, String content, String userId, Long commentId) {
        this.replyId = replyId;
        this.content = content;
        this.userId = userId;
        this.commentId = commentId;
    }
}
