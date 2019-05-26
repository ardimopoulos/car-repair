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
        super(email,password,userType);
        this.vat = vat;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

//    public String getVat() {
//        return vat;
//    }
//
//    public void setVat(String vat) {
//        this.vat = vat;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public user getUser() {
//        return user;
//    }
//
//    public void setUser(user user) {
//        this.user = user;
//    }
//
//    public void setVehicles(vehicle vehicle) {
//        this.vehicles.add(vehicle);
//    }
//
//    public List<vehicle> getVehicles() {
//        return vehicles;
//    }
}
