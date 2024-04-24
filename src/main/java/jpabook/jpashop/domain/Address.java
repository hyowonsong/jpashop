package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // 임베디드 타입 설정해주기
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address(){            // 생성자 추가해줘야 함
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
