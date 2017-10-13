package com.carRepair.carRepair.Domain;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id" ,nullable = false)
    private long userId;

    @Column(nullable = false , length = 32)
    private String email;

    @Column(nullable = false , length = 20)
    private String password;


    @Column(nullable = false , length=1)
    private boolean userType;

    @OneToOne(optional = false, mappedBy = "user", targetEntity = Member.class)
    private Member member;

    public User() {
    }

    public User(String email, String password, boolean userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public long getUserId() { return userId; }

    public void setUserId(long userId) { this.userId = userId; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean getUserType() { return userType; }

    public void setUserType(boolean userType) { this.userType = userType; }

}
