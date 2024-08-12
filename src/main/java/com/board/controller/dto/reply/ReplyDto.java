package com.board.controller.dto.reply;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReplyDto {

    private Long id;
    private String content;
    private String userId;
    private Long commentId;

    @Builder
    public ReplyDto(Long id, String content, String userId, Long commentId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.commentId = commentId;
    }
}
