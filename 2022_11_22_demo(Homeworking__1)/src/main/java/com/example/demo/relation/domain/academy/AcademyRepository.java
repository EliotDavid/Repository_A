package com.example.demo.relation.domain.academy;

import com.example.demo.relation.domain.member.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AcademyRepository {

    @PersistenceContext
    private EntityManager em; // ** 멤버 레파지토리에서 쓰이는 엔티티매니저나 똑같은 애임
                              // ** 왜 나누나면 헷갈릴까봐 나눈다고 함
                              // ** 나중에 합칠거라고 함

    // 사실 얘는 save는 필요없음
    public Academy findById(Long id){
        return em.find(Academy.class, id);
    }

    public List <Academy> findAll(){
        return em.createQuery("select a from Academy a").getResultList();
    }



    //public List<Member> findById(){
        //return em.createQuery("select m from Member as m where m.loginId = '")
    //}

    
    // ** 이름으로 찾는 건 보류함
    //public List <Academy> findByName(String academyName){

        //return em.createQuery("select m from Member m where m.academy.academy_id.academy_name = :name", Academy.class)
                //.setParameter("name", academyName) // 일단 setParameter메서드부터 동작을 함
                // ** 그리고 인자로 받은 academyName이 이 메서드를 실행시킬 key역할을 하면서 일단 setParameter메서드의 2번째 인자 academyName이 들어오고
                // ** 그 다음 setParmeter의 첫번쨰 인자 name이 JPQL의 마지막 : "academy_name"이랑 같은지 비교한다던데 뭔 소리지?
                //.getResultList(); // ** 찾으면 반환해
    //}
}
