package com.carRepair.carRepair.Services.Repair;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.Repair.RepairNotFoundException;
import com.carRepair.carRepair.Repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carRepair.carRepair.Repositories.RepairRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService{

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Repair> getDailyServices(){

        LocalDateTime startDate = LocalDateTime.parse(LocalDate.now()+"T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse(LocalDate.now()+"T23:59:59");

        List<Repair> repairList = repairRepository.findTop10ByRepairDateAfterAndRepairDateBeforeOrderByRepairDateAsc(startDate,endDate);
        return repairList;
    }

    @Override
    public Repair getRepair(long repairId) throws RepairNotFoundException {
        Repair repair = repairRepository.findByRepairId(repairId);
        if(repair == null){
            throw new RepairNotFoundException("Repair not found");
        }
        return repair;
    }


    public List<Repair> getMemberRepairs(String email) throws RepairNotFoundException{

        Member member = memberRepository.findByEmail(email);

        List<Repair> repairList = new ArrayList<>();

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

}
