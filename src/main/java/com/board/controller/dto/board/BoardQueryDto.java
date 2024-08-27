package com.board.controller.dto.board;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class BoardQueryDto {

    private Long id;
    private String title;
    private String content;
    private String userId;
    private List<GetBoardCommentResponseDto> comments;

    public BoardQueryDto(Long id, String title, String content, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public void putComments(List<GetBoardCommentResponseDto> comments) {
        this.comments = comments;
    }
}
