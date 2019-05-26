package com.carRepair.carRepair.domain;

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

//    public long getUserId() { return userId; }
//
//    public void setUserId(long userId) { this.userId = userId; }
//
//    public String getEmail() { return email; }
//
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPassword() { return password; }
//
//    public void setPassword(String password) { this.password = password; }
//
//    public boolean getUserType() { return userType; }
//
//    public void setUserType(boolean userType) {
//        this.userType = userType;
//    }
//
//    public void setMember(member member) {
//        this.member = member;
//    }
//
//    public member getMember() {
//        return member;
//    }

}
