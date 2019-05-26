package com.car_repair_shop.car_repair.repositories;

import com.car_repair_shop.car_repair.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Vehicle save(Vehicle vehicle);

    Vehicle findByPlate(String plate);

    void delete(Long id);
}
