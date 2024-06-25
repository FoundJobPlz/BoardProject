package com.board.controller;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public class ListBoardResponse {

    private final List<ListBoardResponseDto> boardList;

    public ListBoardResponse(List<ListBoardResponseDto> boardList) {
        this.boardList = boardList;
    }

    @JsonValue
    public List<ListBoardResponseDto> getBoardList() {
        return boardList;
    }
}
