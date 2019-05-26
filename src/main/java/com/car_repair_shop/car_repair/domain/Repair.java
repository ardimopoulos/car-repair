package com.car_repair_shop.car_repair.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Repair{

    @Id
    @Column(name = "repair_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long repairId;

    @Column(nullable = false)
    private LocalDateTime repairDate;

    @Column(nullable = false, length = 1)
    private int status;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean type;

    @Column(nullable = false)
    private double cost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

    public Repair(LocalDateTime repairDate, int status, String description, boolean type, double cost) {
        this.repairDate = repairDate;
        this.status = status;
        this.description = description;
        this.type = type;
        this.cost = cost;
    }
}
