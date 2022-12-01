package com.example.demo.relation.domain.service;

import com.example.demo.relation.domain.member.Member;
import com.example.demo.relation.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RelationService {
    private final MemberRepository memberRepository;

    @Transactional
    public void insert(Member member) {
        memberRepository.save(member);
    }

    public List<Member> findById(String loginId) {
        return memberRepository.findById(loginId);
    }
}
