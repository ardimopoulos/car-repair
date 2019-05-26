package com.carRepair.carRepair.services.vehicle;

import com.carRepair.carRepair.domain.Vehicle;
import com.carRepair.carRepair.exceptions.VehicleNotFoundException;

import java.util.List;

public interface VehicleService {

    Vehicle insertVehicle(Vehicle vehicle) throws Exception;

    Vehicle getByPlate(String plate) throws VehicleNotFoundException;

    void deleteVehicle(Long id);

    List<Vehicle> getVehiclesByMemberVat(String vat) throws VehicleNotFoundException;

    List<Vehicle> getVehiclesByMemberPlate(String plate) throws VehicleNotFoundException;
}
