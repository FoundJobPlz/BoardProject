package com.board.service;

import com.board.controller.dto.member.CreateMemberRequestDto;
import com.board.controller.dto.member.MemberDto;
import com.board.controller.dto.member.UpdateMemberRequestDto;
import com.board.repository.BoardRepository;
import com.board.repository.MemberEntity;
import com.board.repository.MemberGrade;
import com.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void createMember(CreateMemberRequestDto createMemberRequestDto) {

        MemberEntity memberEntity = MemberEntity.builder()
                .loginId(createMemberRequestDto.getLoginId())
                .password(createMemberRequestDto.getPassword())
                .username(createMemberRequestDto.getUsername())
                .memberGrade(MemberGrade.USER)
                .build();

        validateDuplicateMember(memberEntity);

        memberRepository.save(memberEntity);
    }

    public List<MemberDto> getMembers() {

        return memberRepository.findAll().stream().map(memberEntity ->
                new MemberDto(
                        memberEntity.getId(),
                        memberEntity.getLoginId(),
                        memberEntity.getPassword(),
                        memberEntity.getUsername()))
                .toList();
    }

    public MemberDto getMember(Long memberId) {
        MemberEntity memberEntity = findByIdOrThrow(memberId);

        return new MemberDto(memberEntity.getId(), memberEntity.getLoginId(), memberEntity.getPassword(), memberEntity.getUsername());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        if (memberRepository.existsById(memberId)) {
            memberRepository.deleteById(memberId);
            return;
        }

        throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }

    @Transactional
    public void updateMemberPasswordAndName(Long memberId, UpdateMemberRequestDto updateMemberRequestDto) {
        MemberEntity findMember = findByIdOrThrow(memberId);

        findMember.updateMemberPassword(updateMemberRequestDto.getPassword());
        findMember.updateMemberUsername(updateMemberRequestDto.getUsername());
    }

    private MemberEntity findByIdOrThrow(Long userId) {
        return memberRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저는 존재하지 않습니다"));
    }

    private void validateDuplicateMember(MemberEntity memberEntity) {
        List<MemberEntity> findMembers = memberRepository.findByLoginId(memberEntity.getLoginId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 회원이 존재합니다.");
        }
    }
}
