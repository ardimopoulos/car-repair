package com.car_repair_shop.car_repair.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Vehicle{

    @Id
    @Column(name = "vehicle_id", nullable = false)
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

    @OneToMany(mappedBy = "vehicle", targetEntity = Repair.class, cascade = CascadeType.ALL)
    private List<Repair> repairs;


    public Vehicle(String plate, String brand, String model, Date year, String color) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }
}
