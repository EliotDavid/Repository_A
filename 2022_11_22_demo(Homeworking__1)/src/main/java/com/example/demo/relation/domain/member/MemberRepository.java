package com.example.demo.relation.domain.member;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    //public List<Member> comparedId(){
        //return em.createQuery("select m from Member m").getResultList();
    //}
}
