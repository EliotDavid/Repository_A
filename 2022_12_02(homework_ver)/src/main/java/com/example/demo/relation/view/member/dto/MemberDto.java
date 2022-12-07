package com.example.demo.relation.view.member.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class MemberDto {

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

    
    // ===================  주소란 및 집코드 입력란
    @NotEmpty(message = "필수 항목입니다")
    private String address1;

    @NotEmpty(message = "필수 항목입니다")
    private String address2;

    @NotEmpty(message = "필수 항목입니다")
    private String zipcode;

    @NotEmpty(message = "필수 항목입니다")
    private String country;

    @NotEmpty(message = "필수 항목입니다")
    private String city;


}
