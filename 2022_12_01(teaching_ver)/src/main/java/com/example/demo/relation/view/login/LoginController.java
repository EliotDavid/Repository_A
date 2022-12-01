package com.example.demo.relation.view.login;

import com.example.demo.relation.domain.login.LoginService;
import com.example.demo.relation.domain.member.Member;
import com.example.demo.relation.view.login.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login(@ModelAttribute("form") LoginDto dto)
    {
        return "login/loginForm";
    }


    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("form") LoginDto dto, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "login/loginForm";

        List<Member> members = loginService.login(dto.getLoginId());//, dto.getPassword());

        if(members.size() == 0)
        {
            bindingResult.reject("loginFail", "ID와 비밀번호를 다시 확인하세요.");
            return "login/loginForm";
        }
        else {
            for (Member member : members)
            {
                if(member.getPassword().equals(dto.getPassword()))
                    return "login/join";
                else
                    return "login/loginForm";
            }
        }

        return "redirect:/";
    }
}
