package com.example.demo.relation.domain.member;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

// ** 엔티티 클래스는 아님
// *** 근데 테이블로 두고는 싶긴 함
@Embeddable // ** 이 어노테이션 :
public class Address {

    @org.springframework.data.relational.core.mapping.Column(value="add1")
    private String address1;

    @org.springframework.data.relational.core.mapping.Column(value="add2")
    private String address2;

    @org.springframework.data.relational.core.mapping.Column(value="zipcode")
    private String zipcode;



}
