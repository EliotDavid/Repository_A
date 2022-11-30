package com.example.demo.relation.view.login;

import com.example.demo.relation.domain.login.LoginService;
import com.example.demo.relation.domain.member.Member;
import com.example.demo.relation.view.login.dto.LoginDto;
import com.example.demo.relation.view.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
public class LoginController {
    // ** 로그인을 할 때 뷰에서 받아서 컨트롤러에서 서비스로 넘어가고 서비스에서 리파지토리로 넘어가야되는데
    // ** 내가 아이디랑 비밀번호 입력했을 때 릴레이션 컨트롤러에서 했던 것처럼 검증단계를 거쳐줘야됨

    private final LoginService loginService;

        /* 로그인은 겟멥핑 할 때는 바인딩리져트가 필요없다고 함
    @GetMapping("/login")
    public String save(@Valid @ModelAttribute("form") MemberDto dto, BindingResult bindingResult) {
        return "login/loginForm";
    }
    */

    @GetMapping("/login")
    public String save(@Valid @ModelAttribute("form") LoginDto dto) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String save(@Valid @ModelAttribute("form") LoginDto dto, BindingResult bindingResult) {
        return loginService.login(dto.getLoginId());
    }
}
