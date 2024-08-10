package com.board.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ListBoardResponseDto {

    private final List<BoardDto> list;
}
