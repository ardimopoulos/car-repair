package com.carRepair.carRepair.Services.Repair;

import com.carRepair.carRepair.Domain.Repair;

import java.time.LocalDate;
import java.util.List;

public interface RepairSearchService {

    public List<Repair> getByDate(String date);

    public List<Repair> getByVat(String vat);

    public List<Repair> getByPlate(String plate);

    public List<Repair> getByBetweenDates(String startDate , String beforeDate);

}
