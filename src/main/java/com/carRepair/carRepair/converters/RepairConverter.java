package com.carRepair.carRepair.converters;

import com.carRepair.carRepair.domain.Repair;
import com.carRepair.carRepair.forms.repair.RepairForm;

public class RepairConverter {

    public static Repair builtRepairObject(RepairForm repairForm) {
        return new Repair(
                repairForm.getRepairDate(),
                Integer.parseInt(repairForm.getStatus()),
                repairForm.getDescription(),
                repairForm.getType().equals("true"),
                Double.valueOf(repairForm.getCost())
        );
    }
}
