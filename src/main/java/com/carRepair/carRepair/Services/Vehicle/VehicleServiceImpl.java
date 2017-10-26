package com.carRepair.carRepair.Services.Vehicle;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.VehicleNotFoundException;
import com.carRepair.carRepair.Repositories.MemberRepository;
import com.carRepair.carRepair.Repositories.VehicleRepository;
import com.carRepair.carRepair.Services.Member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Override
    public Vehicle insertVehicle(Vehicle vehicle) throws Exception {
        Vehicle newVehicle = vehicleRepository.save(vehicle);
        if(newVehicle == null){
            throw new Exception("Vehicle already exists");
        }
        return newVehicle;
    }

    @Override
    public Vehicle getByPlate(String plate) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleRepository.findByPlate(plate);
        if(vehicle == null){
            throw new VehicleNotFoundException("Vehicle with " + plate + " not found");
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getVehiclesByMemberVat(String vat) throws VehicleNotFoundException {
        Member member = memberRepository.findByVat(vat);
        if(member == null){ throw new VehicleNotFoundException("Member not found with vat :" + vat); }
        List<Vehicle> vehicleList = member.getVehicles();
        if(vehicleList.isEmpty()){throw new VehicleNotFoundException("Member with vat :" + vat + " hasn't vehicles! " );}
        return vehicleList;
    }

    @Override
    public List<Vehicle> getVehiclesByMemberPlate(String plate) throws VehicleNotFoundException{
        Vehicle vehicle = vehicleRepository.findByPlate(plate);
        if(vehicle == null ){
            throw new VehicleNotFoundException("Vehicle not exist with palte :" + plate);
        }
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        return vehicles;
    }

    @Override
    public void deleteVehicle(Long id) { vehicleRepository.delete(id); }
}
