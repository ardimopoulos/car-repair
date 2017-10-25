package com.carRepair.carRepair.Services.Repair;

import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Exceptions.Repair.RepairNotFoundException;

import java.util.List;

public interface RepairService {

    List<Repair> getDailyServices(); //TODO throw Esception ???

    Repair getRepair(long repairId) throws RepairNotFoundException;

    List<Repair> getMemberRepairs(String email) throws RepairNotFoundException;



}
