package com.board.service;

import lombok.Data;
import lombok.Setter;

@Data
public class Board {

    private Long id;
    private String title;
    private String content;
    private String userId;

    public Board(Long id, String title, String content, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }


}
