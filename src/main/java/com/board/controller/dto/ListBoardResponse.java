package com.board.controller.dto;

<<<<<<< Updated upstream:src/main/java/com/board/controller/ListBoardResponse.java
import com.fasterxml.jackson.annotation.JsonValue;
=======
>>>>>>> Stashed changes:src/main/java/com/board/controller/dto/ListBoardResponse.java
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Getter
public class ListBoardResponse {

    private final List<ListBoardResponseDto> list;
}
