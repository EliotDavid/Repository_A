package com.example.demo.relation.domain.member;


import com.example.demo.relation.domain.academy.Academy;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Getter
@NoArgsConstructor
@Entity
@SecondaryTables({
        @SecondaryTable(name="member_address", pkJoinColumns = @PrimaryKeyJoinColumn(name="id"))//** address이 위치를 넣어줘야함
})          // ** 이 테이블 만들어서 주소랑 멤버의 id랑 연결시켜라는 뜻임
            // **여기서 name 옆의 속성은 테이블명임
            // ** id를 사용해서 별개의 테이블과 연결 시켜준다는 ㅡ이미임 
            // ** 


public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "password")
    private String password;


    // ** 오더 : 엔티티, 상품 : 엔티티
    // ** 상품은 여러 개 있을 수 있음
    // ** 주문 하나에 여러 개의 상품이 들어 갈 수 있음
    @AttributeOverrides({
            @AttributeOverride(name="address1", column = @Column(table="member_address", name="address1")), 
            // ** 첫번째 name : Address의 필드값과 이름이 맞아야함 // ** column = 부터는 : 테이블명, 칼럼명임 여기서 name은 Address의 변수이름이 아님
            // ** 이 변수명을 이 칼럼으로 세팅할거야라는 뜻임
            // ** 근데 그 변수명이 어디에 있는거야? private Address address 위에 쓴 거라서 Address거를 적용 시킬 수 있는거임
            // ** 변수가 없는데 테이블이랑 연결하려 하면 에러가 남
            
            @AttributeOverride(name="address2", column = @Column(table="member_address", name="address2")),
            @AttributeOverride(name="zipcode", column = @Column(table="member_address", name="zipcode")),
            @AttributeOverride(name="country", column = @Column(table="member_address", name="country")),
            @AttributeOverride(name="City", column = @Column(table="member_address", name="city")),
    })
    private Address address;
    // ** 멤버가 하나이면 어드레스도 하나임
    // ** 그래서 지금 이 코드는 1:1 관계로 작성한 코드라고 함

    /*
    @JoinColumns(value = {@JoinColumn(name = "academy_id")},
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    */

    @JoinColumn(name = "academy_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Academy academy;

    public Member(String loginId, String memberName, String password, Academy academy, Address address) {
        this.loginId = loginId;
        this.memberName = memberName;
        this.password = password;
        this.academy = academy;
        this.address = address;

        /*
        address.setAddress1("");
        address.setAddress2("");
        address.setZipcode("");
        */

    }
}
