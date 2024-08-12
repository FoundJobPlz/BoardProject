package com.board.controller.dto.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
