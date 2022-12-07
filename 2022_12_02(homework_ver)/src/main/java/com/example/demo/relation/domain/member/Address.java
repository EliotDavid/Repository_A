package com.example.demo.relation.domain.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

// ** 이 클래스는 엔티티는 아닌데 엔티티처럼 DB에 테이블로 올려두고 싶을 때 사용하는 클래스임
@Data
@Embeddable
@NoArgsConstructor
public class Address {

    

    @Column(table = "member_address")
    private String address1;

    @Column(table = "member_address")
    private String address2;

    @Column(table = "member_address")
    private String zipcode;

    @Column(table = "member_address")
    private String country;

    @Column(table = "member_address")
    private String city;


    public Address(String address1, String address2, String zipcode, String country, String city){
        this.address1 = address1;
        this.address2 = address2;
        this.zipcode = zipcode;
        this.country = country;
        this.city = city;
    }
}
