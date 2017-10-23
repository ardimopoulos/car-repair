package com.carRepair.carRepair.Services.Vehicle;

import com.carRepair.carRepair.Domain.Vehicle;

public interface VehicleService {

    Vehicle insertVehicle(Vehicle vehicle) throws Exception;

    Vehicle findByPlate(String plate) throws Exception;
}
