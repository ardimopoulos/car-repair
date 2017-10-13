package com.carRepair.carRepair.Domain;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id" ,nullable = false)
    private long memberId;

    @Column(nullable = false)
    private int vat;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String plate;

    @OneToOne(optional = false)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "member", targetEntity = Service.class)
    private Collection service;

    public Member(){}

    public Member(long userId, String email, String password, int userType, int vat, String firstname, String lastname, String plate){
        //super(userId,email,password,userType);
        this.vat = vat;
        this.firstname = firstname;
        this.lastname = lastname;
        this.plate = plate;

    }

    public long getMemberId() { return memberId; }


    public void setMemberId(long memberId) { this.memberId = memberId; }

    public int getVat() { return vat; }

    public void setVat(int vat) { this.vat = vat; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPlate() { return plate; }

    public void setPlate(String plate) { this.plate = plate; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}