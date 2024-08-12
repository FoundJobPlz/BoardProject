package com.board.controller.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ListCommentResponseDto {

    private List<CommentDto> comments;

    @Builder
    public ListCommentResponseDto(List<CommentDto> comments) {
        this.comments = comments;
    }
}
