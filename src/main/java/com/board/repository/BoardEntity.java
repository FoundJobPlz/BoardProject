package com.board.repository;

import lombok.Data;
import lombok.Setter;

@Data
public class BoardEntity {

    private final Long id;
    private final String title;
    private final String content;
    private final String userId;
}
