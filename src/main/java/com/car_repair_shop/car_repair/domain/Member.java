package com.car_repair_shop.car_repair.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Member extends User {

    @Column(nullable = false, length = 9, unique = true)
    private String vat;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String address;

    @OneToOne(optional = false)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "member", targetEntity = Vehicle.class, cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    public Member(String email, String password, boolean userType, String firstname, String lastname,String address, String vat) {
        super(email, password, userType);
        this.vat = vat;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }
}
