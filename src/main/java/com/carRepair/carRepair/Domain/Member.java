package com.carRepair.carRepair.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
public class Member extends User implements Serializable {

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

    @OneToMany(mappedBy = "member", targetEntity = Repair.class,  cascade = CascadeType.ALL) //otan diagrafw member diagrafei kai repair
    private List<Repair> repairs;

    @OneToMany(mappedBy = "member", targetEntity = Vehicle.class,  cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;


    public Member() {
    }


    public Member(String email, String password, boolean userType, String firstname, String lastname,String address, String vat) {
        super(email,password,userType);
        this.vat = vat;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setVehicles(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public Collection getRepairs() {
        return repairs;
    }

    public Collection getVehicles() {
        return vehicles;
    }
}
