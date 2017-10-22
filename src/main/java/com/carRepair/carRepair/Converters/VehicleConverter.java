package com.carRepair.carRepair.Converters;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Forms.UserForm;
import com.carRepair.carRepair.Forms.VehicleForm;
import com.carRepair.carRepair.Utilities.AppUtilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VehicleConverter {

    public static Vehicle buildVehicleObjecr(VehicleForm vehicleForm){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");

        //long user_id = Long.valueOf(vehicleForm.getUserId());
        String vat = vehicleForm.getVat();
        String plate = vehicleForm.getPlate();
        String brand = vehicleForm.getBrand();
        String model = vehicleForm.getModel();
        String color = vehicleForm.getColor();
        Date yearOfModel = null;
        try {
            yearOfModel = formatter.parse(vehicleForm.getYearOfModel());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Vehicle vehicle = new Vehicle(plate, brand, model, yearOfModel, color);

        return vehicle;
    }
}
