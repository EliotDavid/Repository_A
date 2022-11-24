package com.example.demo.relation.domain.academy;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
public class Academy {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "academy_name")
    private String academyName;

   //@OneToMany(mappedBy = "academy")
   //private List<Member> members = new ArrayList<>();

   //public void addMember(Member member)
   //{
   //    members.add(member);
   //}

    public Academy(String academyName) {
        this.academyName = academyName;
    }
}
