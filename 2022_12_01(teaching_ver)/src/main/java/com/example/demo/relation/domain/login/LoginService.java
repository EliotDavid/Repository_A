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


    public List<Member> login(String loginId)//, String password)
    {
        return memberRepository.findByLoginId(loginId);
                //.stream().filter( m -> m.getPassword().equals(password))
                //.collect(Collectors.toList());
    }
}
