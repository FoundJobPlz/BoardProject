package com.board.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateBoardRequestDto {

    private String title;
    private String content;

    public UpdateBoardRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
