package com.carRepair.carRepair.Services.Vehicle;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.Repair.RepairNotFoundException;
import com.carRepair.carRepair.Exceptions.Vehicle.VehicleNotFoundException;
import com.carRepair.carRepair.Repositories.MemberRepository;
import com.carRepair.carRepair.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleSearchServiceImpl implements VehicleSearchService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getByVat(String vat) throws VehicleNotFoundException {

        Member member = memberRepository.findByVat(vat);

        if(member == null){ throw new VehicleNotFoundException("Member not found with vat :" + vat); }
        List<Vehicle> vehicleList = member.getVehicles();
        if(vehicleList.isEmpty()){throw new VehicleNotFoundException("Member with vat :" + vat + " hasn t vehicles! " );}
        return vehicleList;
    }

    public List<Vehicle> getByPlate(String plate) throws VehicleNotFoundException{

        Vehicle vehicle = vehicleRepository.findByPlate(plate);

        if(vehicle == null ){throw new VehicleNotFoundException("Vehicle not exist with palte :" + plate);}else {
            List<Vehicle> vehicles = new ArrayList<>();
            vehicles.add(vehicle);
            return vehicles;
        }
    }

}
