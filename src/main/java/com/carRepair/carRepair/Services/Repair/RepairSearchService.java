package com.carRepair.carRepair.Services.Repair;

import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.Repair.RepairNotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public interface RepairSearchService {

    public List<Repair> getByRepairDate(String date) throws RepairNotFoundException,DateTimeParseException;

    public List<Repair> getByVat(String vat) throws RepairNotFoundException;

    public List<Repair> getByPlate(String plate) throws RepairNotFoundException;

    public List<Repair> getByBetweenRepairDates(String startDate , String beforeDate) throws RepairNotFoundException;

}
