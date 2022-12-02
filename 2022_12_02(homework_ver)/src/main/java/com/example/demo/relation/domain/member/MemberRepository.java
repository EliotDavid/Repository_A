package com.example.demo.relation.domain.member;

import com.example.demo.relation.domain.academy.Academy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public List<Member> findById(String loginId) {
        return em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId)
                .getResultList();
    }

    public List<Member> findByLoginId(String loginId) {
        return em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId)
                .getResultList();
    }

    public List<Academy> findByAcademyName(String academyName) {
        return em.createQuery("select m from Member m where m.academyName = :academyName", Academy.class)
                .setParameter("academyName", academyName)
                .getResultList();
    }
}