package com.example.demo.relation.view.login.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDto {

    @NotEmpty(message = "로그인 ID를 입력하세요")
    private String loginId;

    @NotEmpty(message = "password를 입력하세요")
    private String password;
}
