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
        // Chrome returns format yyyy-mm-dd. Mozilla returns dd/mm/yyyy.
        if (date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            String d = formatLocalDate("dd-MM-yyyy", date).toString();
            date = d;
        }
        LocalDateTime startDate = LocalDateTime.parse(date + "T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse(date + "T23:59:59");

        List<Repair> repairList = repairRepository.findByRepairDateAfterAndRepairDateBefore(startDate, endDate);
        if (repairList.isEmpty()) {
            throw new RepairNotFoundException("Repairs not exist for day " + date);
        }

        return repairList;
    }

    @Override
    public List<Repair> getByBetweenRepairDates(String firstDate , String beforeDate) throws RepairNotFoundException{
        // Chrome returns format yyyy-mm-dd. Mozilla returns dd/mm/yyyy.
        if (firstDate.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            String fDate = formatLocalDate("dd-MM-yyyy", firstDate).toString();
            String bDate = formatLocalDate("dd-MM-yyyy", beforeDate).toString();
            firstDate = fDate;
            beforeDate = bDate;
        }
        LocalDateTime startDate = LocalDateTime.parse(firstDate+"T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse(beforeDate+"T23:59:59");
        List<Repair> repairList = repairRepository.findByRepairDateAfterAndRepairDateBefore(startDate, endDate );
        if(repairList.isEmpty()) { throw new RepairNotFoundException("Repairs not exist for those dates between " + firstDate + " and " + beforeDate); }
        return repairList;
    }

    @Override
    public List<Repair> getByVat(String vat) throws RepairNotFoundException{
        List<Repair> repairList = new ArrayList<>();
            Member member = memberRepository.findByVat(vat);
            if(member == null){throw new RepairNotFoundException("Member not exist with vat "+vat );}
            try {
                List<Vehicle> vehicleList = member.getVehicles();

                for (int i = 0; i < vehicleList.size(); i++) {
                    List<Repair> repairsByVehicle = vehicleList.get(i).getRepairs();
                    for (int j = 0; j < repairsByVehicle.size(); j++) {
                        repairList.add(repairsByVehicle.get(j));
                    }
                }
            }catch (Exception e){ throw new RepairNotFoundException("Repairs not exist for member " + member.getFirstname() + member.getLastname()); }
            return repairList;
        }
    @Override
    public List<Repair> getByPlate(String plate) throws RepairNotFoundException{

        Vehicle vehicle = vehicleRepository.findByPlate(plate);

        if(vehicle == null ){throw new RepairNotFoundException("Vehicle not exist with plate " + plate);}

        if(vehicle.getRepairs() == null){ throw new RepairNotFoundException("Repairs not exist for plate " + plate); }

        List<Repair> repairList = vehicle.getRepairs();
        if(repairList.isEmpty()) { throw new RepairNotFoundException("Repairs not exist for plate " + plate); }
        return repairList;
    }

    private LocalDate formatLocalDate(String format , String date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        return parsedDate; // get (default) format : yyyy-MM-dd
    }

}
