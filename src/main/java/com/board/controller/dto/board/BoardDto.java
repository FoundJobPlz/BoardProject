package com.board.controller.dto.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BoardDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String userId;

}
