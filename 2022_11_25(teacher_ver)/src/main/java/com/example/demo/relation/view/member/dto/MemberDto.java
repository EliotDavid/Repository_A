package com.example.demo.relation.view.member.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class MemberDto {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;

    @NotEmpty
    private String memberName;

    @NotEmpty
    private String academyName;
}
