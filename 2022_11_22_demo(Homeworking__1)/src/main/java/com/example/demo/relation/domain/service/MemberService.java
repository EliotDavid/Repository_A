package com.example.demo.relation.domain.service;

import com.example.demo.relation.domain.member.Member;
import com.example.demo.relation.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void insert(Member member){
        memberRepository.save(member);
    }
}
