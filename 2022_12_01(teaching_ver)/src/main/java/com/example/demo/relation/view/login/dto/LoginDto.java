package com.example.demo.relation.view.login.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDto {

    @NotEmpty(message = "로그인 ID 를 입력하세요.")
    private String loginId;

    @NotEmpty(message = "Password 를 입력하세요.")
    private String password;
}
