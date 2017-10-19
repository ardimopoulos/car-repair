package com.carRepair.carRepair.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long vehicleId;

    @Column(nullable = false, unique = true)
    private String plate;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date year;

    @Column(nullable = false)
    private String color;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_Id", referencedColumnName = "user_id")
    private Member member;

    public Vehicle(){}

    public Vehicle(String plate, String brand, Date year, String color) {
        this.plate = plate;
        this.brand = brand;
        this.year = year;
        this.color = color;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
