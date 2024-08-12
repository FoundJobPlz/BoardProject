package com.board.repository;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "id", length = 30, nullable = false, unique = true)
    private String loginId;

    @Column(name = "pw", nullable = false)
    private String password;

    @Column(name = "username", nullable = false)
    private String username;

    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;

    @Builder
    public MemberEntity(String loginId, String password, String username, MemberGrade memberGrade) {
        this.loginId = loginId;
        this.password = password;
        this.username = username;
        this.memberGrade = memberGrade;
    }

    public void updateMemberPassword(String password) {
        this.password = password;
    }

    public void updateMemberUsername(String username) {
        this.username = username;
    }
}
