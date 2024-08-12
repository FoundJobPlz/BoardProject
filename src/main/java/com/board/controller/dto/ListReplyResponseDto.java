package com.board.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ListReplyResponseDto {

    private List<ReplyDto> replyList;

    @Builder
    public ListReplyResponseDto(List<ReplyDto> replyList) {
        this.replyList = replyList;
    }
}
