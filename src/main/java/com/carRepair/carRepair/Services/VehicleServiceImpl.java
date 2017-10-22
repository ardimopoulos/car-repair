package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private MemberService memberService;

    @Override
    public Vehicle insertVehicle(Vehicle vehicle) throws Exception {

        Vehicle newVehicle = vehicleRepository.save(vehicle);
        if(vehicle == null){
            throw new Exception("Vehicle already exists");
        }
        return vehicle;
    }
}
