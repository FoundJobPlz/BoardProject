package com.board.controller.dto.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String userId;

    @Builder
    public BoardDto(Long id, String title, String content, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
