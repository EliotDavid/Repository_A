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

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "password")
    private String password;

    @Column(name = "userEmail")
    private String userEmail;

    /*
    @JoinColumns(value = {@JoinColumn(name = "academy_id")},
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    */
    @JoinColumn(name = "academy_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Academy academy;

    public Member(String loginId, String memberName, String password, String userEmail, Academy academy) {
        this.loginId = loginId;
        this.memberName = memberName;
        this.password = password;
        this.userEmail = userEmail;
        this.academy = academy;
    }
}
