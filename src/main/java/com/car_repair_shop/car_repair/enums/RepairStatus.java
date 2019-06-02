package com.car_repair_shop.car_repair.enums;

public enum RepairStatus {

    IN_PROGRESS(1),
    COMPLETED(2),
    PENDING(3);

    private int value;

    RepairStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
