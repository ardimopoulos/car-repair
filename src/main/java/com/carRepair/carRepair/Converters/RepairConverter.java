package com.carRepair.carRepair.Converters;

import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Forms.Repair.RepairForm;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RepairConverter {

    public static Repair builtRepairObject(RepairForm repairForm) throws ParseException {//vat date time status description type


        boolean repairType = (repairForm.getType().equals("true")) ? true : false;

        LocalDateTime date = LocalDateTime.parse(repairForm.getDate());

        int status = Integer.parseInt(repairForm.getStatus());
        String description = repairForm.getDescription();
        boolean type = repairType;
        double cost = Double.valueOf(repairForm.getCost());

        Repair repair = new Repair(date, status, description, type, cost);

        return repair;
    }
}
