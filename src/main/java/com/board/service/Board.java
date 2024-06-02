package com.board.service;

import lombok.Data;

@Data
public class Board {

    private final Long id;
    private final String title;
    private final String content;
    private final String userId;
}
