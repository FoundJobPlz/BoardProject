package com.board.controller;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListBoardResponse {

    private final List<ListBoardResponseDto> list;
}
