package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.carRepair.carRepair.Repositories.RepairRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@org.springframework.stereotype.Service
public class RepairServiceImpl implements RepairService{

    @Autowired
    private RepairRepository repairRepository;

    public List<Service> getDailyServices(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        System.out.println("edw");
        List<Service> serviceList = repairRepository.findByDateOrderByTimeAsc(java.sql.Date.valueOf(localDate));
        for(int i=0; i<serviceList.size(); i++){
            System.out.println(serviceList.get(i).getDescription());
        }
        return serviceList;
    }
    public String formatStringDate(String format , LocalDate date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String stringDate = date.format(formatter);
        return stringDate;
    }

}
