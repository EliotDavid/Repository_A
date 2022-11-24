package com.example.demo.relation.view.member.dto;

import com.example.demo.relation.domain.academy.Academy;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class MemberDto {

    // @Notnull : 아무거나 뭔가를 공백이라도 넣을 수 있음
    @NotEmpty // ** 얘를 비어있는 상태로 받을 수 없다는 뜻임 // 비워 둘 수가 없어 // 무조건 채워야 돼 라는 뜻임
    private String loginId; //
    @NotEmpty
    private String password;
    @NotEmpty
    private String memberName;

    @NotEmpty
    private String academyName;


    //private Academy academy;
}
