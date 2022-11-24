package com.example.demo.relation.domain.member;


import com.example.demo.relation.domain.academy.Academy;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;


    @Column(name = "member_name")
    private String memberName;

    @Column(name = "login_Id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @JoinColumn(name = "academy_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Academy academy;

    public Member(String memberName, String loginId, String password, Academy academy)
    {
        this.memberName = memberName;
        this.academy = academy;
        this.loginId = loginId;
        this.password = password;
    }
}
