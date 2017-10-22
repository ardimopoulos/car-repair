package com.carRepair.carRepair.Services.Repair;

import com.carRepair.carRepair.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairDeleteServiceImpl {

    @Autowired
    private RepairRepository repairRepository;

    public void deleteRepair(Long id){repairRepository.delete(id);}


}
