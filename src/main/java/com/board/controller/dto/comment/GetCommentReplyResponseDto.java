package com.board.controller.dto.comment;

import com.board.controller.dto.reply.ReplyDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetCommentReplyResponseDto {

    private Long commentId;
    private String content;
    private String userId;

    private List<ReplyDto> replies;

    @Builder
    public GetCommentReplyResponseDto(Long commentId, String content, String userId, List<ReplyDto> replies) {
        this.commentId = commentId;
        this.content = content;
        this.userId = userId;
        this.replies = replies;
    }
}
