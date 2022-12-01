package com.example.demo.relation.domain.academy;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AcademyRepository {
    @PersistenceContext
    private EntityManager em;

    public Academy findById(Long id) {
        return em.find(Academy.class, id);
    }

    public List<Academy> findAll() {
        return em.createQuery("select a from Academy a", Academy.class).getResultList();
    }

    public List<Academy> findByName(String academyName) {
        return em.createQuery("select a from Academy a where a.academyName = :name", Academy.class)
                .setParameter("name", academyName) // ** 아카데미 엔티티로 만들어진 아카데미 테이블에 name이란 속성에 담긴 값이 아카데미 데이터타입으로 만들어진 여러개의 아이디가 부여되어 여러개의 객체로 만들어진 a라는 객체의 필드값 중 학명이라는 필드값에 들어있는 값과 같은게 있는지 조회해라라는 뜻
                .getResultList(); // ** 그렇게 해서 그런 객체가 있으면 그 학원명을 가진 객체수 만큼을 담고 있는 리스트를 만들어서 그 결과의 리스트를 반환해라는 뜻
    }
}
