package com.car_repair_shop.car_repair.services.repair;

import com.car_repair_shop.car_repair.domain.Member;
import com.car_repair_shop.car_repair.domain.Repair;
import com.car_repair_shop.car_repair.domain.Vehicle;
import com.car_repair_shop.car_repair.exceptions.DateParseException;
import com.car_repair_shop.car_repair.exceptions.RepairNotFoundException;
import com.car_repair_shop.car_repair.repositories.MemberRepository;
import com.car_repair_shop.car_repair.repositories.RepairRepository;
import com.car_repair_shop.car_repair.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RepairServiceImpl implements RepairService{

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Repair insertRepair(Repair repair) throws Exception {
        Repair newRepair = repairRepository.save(repair);

        if (newRepair == null) {
            throw new Exception("Unable to save repair");
        }

        return newRepair;
    }

    public List<Repair> getDailyServices(){
        LocalDateTime startDate = LocalDateTime.parse(LocalDate.now()+"T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse(LocalDate.now()+"T23:59:59");
        return repairRepository.findTop10ByRepairDateBetweenOrderByRepairDateAsc(startDate,endDate);
    }

    @Override
    public Repair getRepair(long repairId) throws RepairNotFoundException {
        Repair repair = repairRepository.findByRepairId(repairId);

        if (repair == null) {
            throw new RepairNotFoundException("repair not found");
        }

        return repair;
    }

    public List<Repair> getMemberRepairs(String email) throws RepairNotFoundException{
        Member member = memberRepository.findByEmail(email);
        List<Repair> repairList = new ArrayList<>();

        try {
            List<Vehicle> vehicleList = member.getVehicles();

            for (int i = 0; i < vehicleList.size(); i++) {
                List<Repair> repairsByVehicle = vehicleList.get(i).getRepairs();

                for (int j = 0; j < repairsByVehicle.size(); j++) {
                    repairList.add(repairsByVehicle.get(j));
                }
            }

        } catch (Exception e) {
            throw new RepairNotFoundException("Repairs not exist for member " + member.getFirstname() + member.getLastname());
        }

        return repairList;
    }

    @Override
    public void deleteRepair(Long id){ repairRepository.delete(id); }

    @Override
    public List<Repair> getByRepairDate(String date)throws RepairNotFoundException, DateParseException {
        LocalDate formatDate;

        try {
            formatDate = formatLocalDate("yyyy-MM-dd",date);

        } catch (DateTimeParseException dateTimeParse) {
            throw new DateParseException("Cant use this format. Use the datepicker!");
        }

        LocalDateTime startDate = LocalDateTime.parse(formatDate + "T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse(formatDate + "T23:59:59");

        List<Repair> repairList = repairRepository.findByRepairDateAfterAndRepairDateBefore(startDate , endDate);

        if (repairList.isEmpty()) {
            throw new RepairNotFoundException("Repairs not exist for day " + date);
        }

        return repairList;
    }

    @Override
    public List<Repair> getByVat(String vat) throws RepairNotFoundException{
        List<Repair> repairList = new ArrayList<>();
        Member member = memberRepository.findByVat(vat);

        if (member == null) {
            throw new RepairNotFoundException("member not exist with vat "+vat );
        }

        try {
            List<Vehicle> vehicleList = member.getVehicles();

            for (int i = 0; i < vehicleList.size(); i++) {
                List<Repair> repairsByVehicle = vehicleList.get(i).getRepairs();

                for (int j = 0; j < repairsByVehicle.size(); j++) {
                    repairList.add(repairsByVehicle.get(j));
                }
            }

            if (repairList.isEmpty()) {
                throw new RepairNotFoundException("Repairs not exist for member " + member.getFirstname() + member.getLastname());
            }

        } catch (Exception e) {
            throw new RepairNotFoundException("Repairs not exist for member " + member.getFirstname() + member.getLastname());
        }

        return repairList;
    }

    @Override
    public List<Repair> getByPlate(String plate) throws RepairNotFoundException{
        Vehicle vehicle = vehicleRepository.findByPlate(plate);

        if (vehicle == null ) {
            throw new RepairNotFoundException("vehicle not exist with plate " + plate);
        }

        if (vehicle.getRepairs() == null) {
            throw new RepairNotFoundException("Repairs not exist for plate " + plate);
        }

        List<Repair> repairList = vehicle.getRepairs();

        if (repairList.isEmpty()) {
            throw new RepairNotFoundException("Repairs not exist for plate " + plate);
        }

        return repairList;
    }

    @Override
    public List<Repair> getByBetweenRepairDates(String firstDate , String beforeDate) throws RepairNotFoundException,DateParseException{
        LocalDate date1;
        LocalDate date2;

        try {
            date1 = formatLocalDate("yyyy-MM-dd", firstDate);
            date2 = formatLocalDate("yyyy-MM-dd", beforeDate);

        } catch (DateTimeParseException dateTimeParse) {
            throw new DateParseException("Cant use this format. Use the datepicker!");
        }

        LocalDateTime startDate = LocalDateTime.parse(date1+"T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse(date2+"T23:59:59");
        List<Repair> repairList = repairRepository.findByRepairDateAfterAndRepairDateBefore(startDate, endDate);

        if (repairList.isEmpty()) {
            throw new RepairNotFoundException("Repairs not exist for those dates between " + firstDate + " and " + beforeDate);
        }

        return repairList;
    }

    private LocalDate formatLocalDate(String format , String date) throws DateTimeParseException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, formatter);
    }

}