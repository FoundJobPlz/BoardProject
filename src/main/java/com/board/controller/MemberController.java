package com.board.controller;

import com.board.controller.dto.CreateMemberRequestDto;
import com.board.controller.dto.ListMemberResponseDto;
import com.board.controller.dto.MemberDto;
import com.board.controller.dto.UpdateMemberRequestDto;
import com.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody CreateMemberRequestDto createMemberRequestDto) {
        memberService.createMember(createMemberRequestDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ListMemberResponseDto> getMemberList() {
        ListMemberResponseDto response = ListMemberResponseDto.builder().list(memberService.getMembers()).build();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{memberId}")
    public ResponseEntity<MemberDto> getMember(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(memberService.getMember(memberId));
    }

    @DeleteMapping(path = "/{memberId}")
    public ResponseEntity<?> deleteMember(@PathVariable("memberId") Long memberId) {
        memberService.deleteMember(memberId);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<?> updateMember(@PathVariable("memberId") Long memberId, @RequestBody UpdateMemberRequestDto updateMemberRequestDto) {
        memberService.updateMemberPasswordAndName(memberId, updateMemberRequestDto);

        return ResponseEntity.ok().build();
    }
}
