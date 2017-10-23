package com.carRepair.carRepair.Services.Repair;

import com.carRepair.carRepair.Domain.Repair;

public interface RepairCreateService {

    Repair insertRepair(Repair repair) throws Exception;
}
