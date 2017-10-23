package com.carRepair.carRepair.Services.Repair;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carRepair.carRepair.Repositories.RepairRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        List<Repair> repairList = repairRepository.findByRepairDateAfterAndRepairDateBefore(startDate,endDate);
        return repairList;
    }


    public List<Repair> getMemberRepairs(String email){

        Member member = memberRepository.findByEmail(email);

       // List<Repair> repairs =  repairRepository.findByMember(member);

        return  null;
    }

}
