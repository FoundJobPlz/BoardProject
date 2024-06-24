package com.board.controller;

import lombok.Data;

@Data
public class GetBoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String userId;

    public GetBoardResponseDto(Long id, String title, String content, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
