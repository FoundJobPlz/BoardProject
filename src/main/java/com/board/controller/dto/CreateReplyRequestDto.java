package com.board.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateReplyRequestDto {

    private String content;
    private String userId;
}
