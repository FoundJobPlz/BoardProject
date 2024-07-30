package com.board.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCommentRequestDto {

    private String content;

    public UpdateCommentRequestDto(String content) {
        this.content = content;
    }

    public UpdateCommentRequestDto() {
    }
}
