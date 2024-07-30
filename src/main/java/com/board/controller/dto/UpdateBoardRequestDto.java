package com.board.controller.dto;

import lombok.Data;

@Data
public class UpdateBoardRequestDto {

    private final String title;
    private final String content;

}
