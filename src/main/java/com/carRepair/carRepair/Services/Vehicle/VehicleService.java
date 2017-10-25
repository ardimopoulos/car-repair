package com.carRepair.carRepair.Services.Vehicle;

import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.Vehicle.VehicleNotFoundException;

public interface VehicleService {

    Vehicle insertVehicle(Vehicle vehicle) throws Exception;

    Vehicle findByPlate(String plate) throws VehicleNotFoundException;
}
