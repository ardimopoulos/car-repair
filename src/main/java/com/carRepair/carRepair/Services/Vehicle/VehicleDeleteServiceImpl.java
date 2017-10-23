package com.carRepair.carRepair.Services.Vehicle;


import com.carRepair.carRepair.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleDeleteServiceImpl implements VehicleDeleteService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public void deleteVehicle(Long id) { vehicleRepository.delete(id); }

}
