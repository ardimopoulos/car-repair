package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Repair;
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

    public List<Repair> getDailyServices(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        List<Repair> repairList = repairRepository.findByDateOrderByTimeAsc(java.sql.Date.valueOf(localDate));
        return repairList;
    }


}
