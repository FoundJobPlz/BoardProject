package com.board.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
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
