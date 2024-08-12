package com.board.controller.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateBoardRequestDto {

    private String title;
    private String content;
    private String userId;

}
