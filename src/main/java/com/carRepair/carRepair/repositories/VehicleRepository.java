package com.carRepair.carRepair.repositories;

import com.carRepair.carRepair.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Vehicle save(Vehicle vehicle);

    Vehicle findByPlate(String plate);

    void delete(Long id);
}
