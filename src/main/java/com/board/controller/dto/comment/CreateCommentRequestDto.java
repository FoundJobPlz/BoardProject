package com.board.controller.dto.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCommentRequestDto {

    private String content;
    private String userId;

}