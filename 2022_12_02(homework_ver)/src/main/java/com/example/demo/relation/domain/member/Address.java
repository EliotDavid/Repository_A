package com.example.demo.relation.domain.member;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

// ** 이 클래스는 엔티티는 아닌데 엔티티처럼 DB에 테이블로 올려두고 싶을 때 사용하는 클래스임
@Data
@Embeddable
public class Address {

    

    @Column(table = "member_address")
    private String address1;

    @Column(table = "member_address")
    private String address2;

    @Column(table = "member_address")
    private String zipcode;
}
