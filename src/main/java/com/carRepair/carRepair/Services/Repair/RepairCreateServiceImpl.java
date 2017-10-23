package com.carRepair.carRepair.Services.Repair;

import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairCreateServiceImpl implements RepairCreateService {

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public Repair insertRepair(Repair repair) throws Exception {

        Repair newRepair = repairRepository.save(repair);
        if(repair == null){
            throw new Exception("Unable to save repair");
        }
        return repair;
    }
}
