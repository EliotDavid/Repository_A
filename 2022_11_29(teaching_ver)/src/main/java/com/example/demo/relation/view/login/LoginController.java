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

import javax.naming.Binding;
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
    { // ** BindingResult를 쓰려면 @Valid @ModelAttribute()를 써야함

        if(bindingResult.hasErrors())
            return "login/loginForm"; // ** 뭔가 에러가 있으면 다시 로그인 페이지로 이동



        List<Member> members = loginService.login(dto.getLoginId(), dto.getPassword());

        if(members.size() == 0){
            return "login/loginForm";
        }
        //System.out.println(members.size());


        for(Member member : members){
            if(member == null) // **
                return "login/loginForm";
            else
                return "login/join";
        }

            return "redirect:/";

        }
}
