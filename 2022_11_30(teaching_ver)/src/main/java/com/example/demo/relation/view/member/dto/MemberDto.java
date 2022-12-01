package com.example.demo.relation.view.member.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class MemberDto {

    // ** NotEmpty : Notempty가 달린 상태에서 message가 쓰이면 비어있을 수 없음이란 메세지를 알린다
    @NotEmpty(message = "사용자 ID는 필수 항목 입니다.")
    private String loginId;

    @NotEmpty(message = "필수 항목 입니다.")
    private String userEmail;

    @NotEmpty(message = "필수 항목 입니다.")
    private String password;

    @NotEmpty(message = "필수 항목 입니다.")
    private String passwordConfirm;

    @NotEmpty(message = "필수 항목 입니다.")
    private String memberName;

    @NotEmpty(message = "필수 항목 입니다.")
    private String academyName;
}
