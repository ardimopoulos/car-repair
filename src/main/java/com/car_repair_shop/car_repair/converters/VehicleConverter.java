package com.car_repair_shop.car_repair.converters;

import com.car_repair_shop.car_repair.domain.Vehicle;
import com.car_repair_shop.car_repair.forms.vehicle.VehicleForm;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VehicleConverter {

    public static Vehicle buildVehicleObjecr(VehicleForm vehicleForm) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");

        return new Vehicle(
                vehicleForm.getPlate(),
                vehicleForm.getBrand(),
                vehicleForm.getModel(),
                formatter.parse(vehicleForm.getYearOfModel()),
                vehicleForm.getColor()
        );
    }

    public static VehicleForm buildVehicleFormObject(Vehicle vehicle){
        return new VehicleForm(
                String.valueOf(vehicle.getVehicleId()),
                vehicle.getMember().getVat(),
                vehicle.getPlate(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getColor(),
                vehicle.getYear().toString().substring(0,4)
        );
    }
}
