package com.car_repair_shop.car_repair.services.vehicle;

import com.car_repair_shop.car_repair.domain.Vehicle;
import com.car_repair_shop.car_repair.exceptions.VehicleNotFoundException;

import java.util.List;

public interface VehicleService {

    Vehicle insertVehicle(Vehicle vehicle) throws Exception;

    Vehicle getByPlate(String plate) throws VehicleNotFoundException;

    void deleteVehicle(Long id);

    List<Vehicle> getVehiclesByMemberVat(String vat) throws VehicleNotFoundException;

    List<Vehicle> getVehiclesByMemberPlate(String plate) throws VehicleNotFoundException;
}
