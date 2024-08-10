package com.board.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateBoardRequestDto {

    private String title;
    private String content;
    private String userId;

    public CreateBoardRequestDto(String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
