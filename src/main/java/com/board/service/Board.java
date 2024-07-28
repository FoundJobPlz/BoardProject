package com.board.service;

import lombok.Data;

@Data
public class Board {

    private Long id;
    private String title;
    private String content;
    private String userId;

    public Board(String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }


}
