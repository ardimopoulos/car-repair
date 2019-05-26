package com.carRepair.carRepair.services.repair;

import com.carRepair.carRepair.domain.Repair;
import com.carRepair.carRepair.exceptions.DateParseException;
import com.carRepair.carRepair.exceptions.RepairNotFoundException;

import java.util.List;

public interface RepairService {

    Repair insertRepair(Repair repair) throws Exception;

    List<Repair> getDailyServices(); //TODO throw Esception ???

    Repair getRepair(long repairId) throws RepairNotFoundException;

    List<Repair> getMemberRepairs(String email) throws RepairNotFoundException;

    void deleteRepair(Long id);

    List<Repair> getByRepairDate(String date) throws RepairNotFoundException,DateParseException;

    List<Repair> getByVat(String vat) throws RepairNotFoundException;

    List<Repair> getByPlate(String plate) throws RepairNotFoundException;

    List<Repair> getByBetweenRepairDates(String startDate , String beforeDate) throws RepairNotFoundException , DateParseException;
}
