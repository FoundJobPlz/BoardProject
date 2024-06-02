package com.board.controller;

import lombok.Data;

@Data
public class CreateBoardRequestDto {

    private String title;
    private String content;
    private String userId;
}
