package com.board.controller;

import lombok.Data;

@Data
public class ListBoardResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String userId;
}
