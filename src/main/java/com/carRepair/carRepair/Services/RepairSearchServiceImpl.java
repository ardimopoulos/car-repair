package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Repositories.MemberRepository;
import com.carRepair.carRepair.Repositories.RepairRepository;
import com.carRepair.carRepair.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RepairSearchServiceImpl implements RepairSearchService{

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Repair> getByDate(String date){

        List<Repair> repairList = repairRepository.findByDate(java.sql.Date.valueOf(formatLocalDate("yyyy/MM/dd" , date)));
        return repairList;
    }

        public LocalDate formatLocalDate(String format , String date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        return parsedDate; // get (default) format : yyyy-MM-dd
    }

    public List<Repair> getByVat(String vat){

            Member member = memberRepository.findByVat(vat);

            List<Repair> repairs = repairRepository.findByMember(member);

            return repairs;
    }

    public List<Repair> getByPlate(String plate){

        Vehicle vehicle = vehicleRepository.findByPlate(plate);

        List<Repair> repairs = repairRepository.findByMember(vehicle.getMember());

        return repairs;
    }

    public List<Repair> getByBetweenDates(String startDate , String beforeDate){

        List<Repair> repairs = repairRepository.findByDateAfterAndDateBefore(java.sql.Date.valueOf(formatLocalDate("yyyy/MM/dd" , startDate) ), java.sql.Date.valueOf(formatLocalDate("yyyy/MM/dd" , beforeDate) ) );

        return repairs;
    }

}
