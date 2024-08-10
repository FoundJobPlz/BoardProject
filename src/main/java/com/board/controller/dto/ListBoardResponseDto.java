package com.board.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ListBoardResponseDto {

    private List<BoardDto> list;

    @Builder
    public ListBoardResponseDto(List<BoardDto> list) {
        this.list = list;
    }
}
