package com.board.controller.dto.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ListMemberResponseDto {

    private List<MemberDto> list;

    @Builder
    public ListMemberResponseDto(List<MemberDto> list) {
        this.list = list;
    }
}
