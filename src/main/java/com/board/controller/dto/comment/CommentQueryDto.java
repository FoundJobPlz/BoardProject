package com.board.controller.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class CommentQueryDto {

    private Long id;
    private String content;
    private String userId;
    private Long boardId;
    private List<GetCommentReplyResponseDto> replyList;

    private String createdBy;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public CommentQueryDto(Long id, String content, String userId, Long boardId, String createdBy, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.boardId = boardId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public void putReplyList(List<GetCommentReplyResponseDto> replyList) {
        this.replyList = replyList;
    }
}
