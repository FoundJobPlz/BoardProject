package com.board.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateMemberRequestDto {

    @NotEmpty(message = "ID는 필수 입니다.")
    private String loginId;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotEmpty(message = "닉네임을 입력해주세요.")
    private String username;
}
