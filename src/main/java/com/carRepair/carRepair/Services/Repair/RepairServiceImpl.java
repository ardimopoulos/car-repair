package com.carRepair.carRepair.Services.Repair;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carRepair.carRepair.Repositories.RepairRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService{

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Repair> getDailyServices(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        List<Repair> repairList = repairRepository.findFirst10ByDateOrderByTimeAsc(java.sql.Date.valueOf(localDate));
        return repairList;
    }


    public List<Repair> getMemberRepairs(String email){

        Member member = memberRepository.findByEmail(email);

        List<Repair> repairs =  repairRepository.findByMember(member);

        return  repairs;
    }

}
