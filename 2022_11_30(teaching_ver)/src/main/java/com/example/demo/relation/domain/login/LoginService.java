package com.example.demo.relation.domain.login;


import com.example.demo.relation.domain.member.Member;
import com.example.demo.relation.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public List<Member> login(String loginId, String password)
    {
        return memberRepository.findByLoginId(loginId)
                .stream().filter(m->m.getPassword().equals(password)) // ** 람다식 표현임
                .collect(Collectors.toList()); // ** 니기 받아온 애들 중에 이 패스워드를 가진 애가 있다면 걔를 반환해라는 애임
                // ** 근데 그런 비밀번호를 가진 애가 하나가 아닐 것이라고 생각해서 여러개를 반환함

    }
}
