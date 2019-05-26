package com.car_repair_shop.car_repair.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
public class User{

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean userType;    // value true means ADMIN - value false means USER

    @OneToOne(optional = false, mappedBy = "user", targetEntity = Member.class, cascade = CascadeType.ALL)
    private Member member;

    public User(String email, String password, boolean userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
}
