package com.carRepair.carRepair.Repositories;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Vehicle save(Vehicle vehicle);

    Vehicle findByPlate(String plate);
}
