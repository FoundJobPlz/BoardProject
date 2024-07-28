package com.board.controller;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class ListBoardResponse {

    private final List<ListBoardResponseDto> list;
}
