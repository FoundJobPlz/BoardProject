package com.board.controller;

import lombok.Getter;

@Getter
public class ListBoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String userId;

    public ListBoardResponseDto(Long id, String title, String content, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
