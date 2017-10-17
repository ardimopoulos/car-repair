package com.carRepair.carRepair.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Member extends User implements Serializable {

    @Column(nullable = false, length = 9)
    private int vat;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String address;

    @OneToOne(optional = false)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "member", targetEntity = Service.class)
    private Collection services;

    @OneToMany(mappedBy = "member", targetEntity = Vehicle.class)
    private Collection vehicles;


    public Member() {
    }


    public Member(long userId, String email, String password, int userType, int vat, String firstname, String lastname, String plate) {
        //super(userId,email,password,userType);
        this.vat = vat;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
