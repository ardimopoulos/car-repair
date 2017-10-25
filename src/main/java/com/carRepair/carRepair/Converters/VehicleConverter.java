package com.carRepair.carRepair.Converters;

import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Forms.Vehicle.VehicleForm;

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

    public static VehicleForm buildVehicleFormObject(Vehicle vehicle){
        String vehicleId = String.valueOf(vehicle.getVehicleId());
        String plate = vehicle.getPlate();
        String vat = vehicle.getMember().getVat();
        String brand = vehicle.getBrand();
        String model = vehicle.getModel();
        String color = vehicle.getColor();
        String year = vehicle.getYear().toString().substring(0,4);

        VehicleForm vehicleForm = new VehicleForm(vehicleId,vat,plate,brand,model,color,year);
        return vehicleForm;
    }
}
