package com.example.demo.relation.domain.repository;


import com.example.demo.relation.domain.member.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void insert(Member member)
    {
        em.persist(member);
    }
}
