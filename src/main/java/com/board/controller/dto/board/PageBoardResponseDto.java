package com.board.controller.dto.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor
public class PageBoardResponseDto {

    private Page<BoardDto> page;

    @Builder
    public PageBoardResponseDto(Page<BoardDto> page) {
        this.page = page;
    }
}
