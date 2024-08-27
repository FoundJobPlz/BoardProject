package com.board.controller.dto.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberDto {

    private final Long id;
    private final String loginId;
    private final String password;
    private final String username;

}
