package com.carRepair.carRepair.Services.Vehicle;

import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.VehicleNotFoundException;

import java.util.List;

public interface VehicleService {

    Vehicle insertVehicle(Vehicle vehicle) throws Exception;

    Vehicle getByPlate(String plate) throws VehicleNotFoundException;

    void deleteVehicle(Long id);

    List<Vehicle> getVehiclesByMemberVat(String vat) throws VehicleNotFoundException;

    List<Vehicle> getVehiclesByMemberPlate(String plate) throws VehicleNotFoundException;

    /*void deleteVehicle(Long id);

    List<Vehicle> getVehiclesByMemberVat(String vat) throws VehicleNotFoundException;

    List<Vehicle> getVehiclesByMemberPlate(String plate) throws VehicleNotFoundException;*/
}
