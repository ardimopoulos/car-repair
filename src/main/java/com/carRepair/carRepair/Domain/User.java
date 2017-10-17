package com.carRepair.carRepair.Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable{

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean userType;    // value true means ADMIN - value false means USER

   /* @OneToOne(optional = false, mappedBy = "user", targetEntity = Member.class)
    private Member member;*/

    public User(){}

    public User(/*long userId,*/ String email, String password, boolean userType) {
       /* this.userId = userId;*/
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getUserType() {
        return userType;
    }

   /* public void setUserType(boolean userType) {
        this.userType = userType;
    }

    public void getRole() {
        if (this.userType){ return ADMIN; }else{return USER;}
    }*/

}
