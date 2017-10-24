package com.carRepair.carRepair.Services.Repair;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.Repair.RepairNotFoundException;
import com.carRepair.carRepair.Repositories.MemberRepository;
import com.carRepair.carRepair.Repositories.RepairRepository;
import com.carRepair.carRepair.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepairSearchServiceImpl implements RepairSearchService{

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Repair> getByRepairDate(String date)throws RepairNotFoundException,DateTimeParseException {
        LocalDate date1 = formatLocalDate("dd-MM-yyyy",date);
        LocalDateTime startDate = LocalDateTime.parse(date1+"T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse(date1+"T23:59:59");

        List<Repair> repairList = repairRepository.findByRepairDateAfterAndRepairDateBefore(startDate , endDate);
        if(repairList.isEmpty()){throw new RepairNotFoundException("Repairs not exist for day " + date);}

        return repairList;

        }

    @Override
    public List<Repair> getByVat(String vat) throws RepairNotFoundException{

            Member member = memberRepository.findByVat(vat);
            if(member == null){throw new RepairNotFoundException("Member not exist with vat "+vat );}
            //List<Repair> repairList = repairRepository.findByMember(member);
            List<Vehicle> vehicleList = member.getVehicles();
            List<Repair> repairList = new ArrayList<>();
            for(int i=0; i<vehicleList.size(); i++){ repairList.add( vehicleList.get(i).getRepairs().get(i) ); }
            if(repairList.isEmpty() ) { throw new RepairNotFoundException("Repairs not exist for member " + member.getFirstname() + member.getLastname()); }
            return repairList;
        }
    @Override
    public List<Repair> getByPlate(String plate) throws RepairNotFoundException{

        Vehicle vehicle = vehicleRepository.findByPlate(plate);

        if(vehicle == null ){throw new RepairNotFoundException("Vehicle not exist with palte" + plate);}

        if(vehicle.getRepairs() == null){ throw new RepairNotFoundException("Repairs not exist for palte " + plate); }

        List<Repair> repairList = vehicle.getRepairs();
        if(repairList.isEmpty()) { throw new RepairNotFoundException("Repairs not exist for palte " + plate); }
        return repairList;
    }

    @Override
    public List<Repair> getByBetweenRepairDates(String firstDate , String beforeDate) throws RepairNotFoundException{
        LocalDate date1 = formatLocalDate("yyyy-MM-dd",firstDate);
        LocalDate date2 = formatLocalDate("yyyy-MM-dd",beforeDate);
        LocalDateTime startDate = LocalDateTime.parse(date1+"T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse(date2+"T23:59:59");
        List<Repair> repairList = repairRepository.findByRepairDateAfterAndRepairDateBefore(startDate, endDate );
        if(repairList.isEmpty()) { throw new RepairNotFoundException("Repairs not exist for those dates between " + startDate + " and " + beforeDate); }
        return repairList;
    }


    public LocalDate formatLocalDate(String format , String date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        return parsedDate; // get (default) format : yyyy-MM-dd
    }

}
