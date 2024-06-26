package com.board.controller;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
public class UpdateBoardRequestDto {

    private final String title;
    private final String content;

}
