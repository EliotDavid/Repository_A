package com.example.demo.relation.domain.login;


import com.example.demo.relation.domain.member.Member;
import com.example.demo.relation.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public String login(String loginId)
    {
        Member member = memberRepository.findByLoginId(loginId);

        if(member == null)
            return "login/loginForm";
        else
            return "redirect:/";
    }
}
