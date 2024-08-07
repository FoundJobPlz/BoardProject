package com.board.controller;

import lombok.Data;

@Data
public class CreateBoardRequestDto {

    private final String title;
    private final String content;
    private final String userId;
}
