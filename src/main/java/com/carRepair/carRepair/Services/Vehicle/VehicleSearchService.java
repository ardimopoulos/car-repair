package com.carRepair.carRepair.Services.Vehicle;

import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.Vehicle.VehicleNotFoundException;

import java.util.List;

public interface VehicleSearchService {

    List<Vehicle> getByVat(String vat) throws VehicleNotFoundException;

    List<Vehicle> getByPlate(String plate) throws VehicleNotFoundException;
}
