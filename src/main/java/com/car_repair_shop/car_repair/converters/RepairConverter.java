package com.car_repair_shop.car_repair.converters;

import com.car_repair_shop.car_repair.domain.Repair;
import com.car_repair_shop.car_repair.forms.repair.RepairForm;

public class RepairConverter {

    public static Repair builtRepairObject(RepairForm repairForm) {
        return new Repair(
                repairForm.getRepairDate(),
                Integer.parseInt(repairForm.getStatus()),
                repairForm.getDescription(),
                "true".equals(repairForm.getType()),
                Double.valueOf(repairForm.getCost())
        );
    }
}
