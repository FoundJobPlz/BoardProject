package com.board.controller;

import lombok.Data;

@Data
public class CreateBoardRequestDto {

    private String title;
    private String content;
    private String userId;

    public CreateBoardRequestDto() {
    }

    public CreateBoardRequestDto(String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
