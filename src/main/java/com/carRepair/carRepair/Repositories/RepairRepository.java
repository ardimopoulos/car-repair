package com.carRepair.carRepair.Repositories;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface RepairRepository extends CrudRepository<Repair, Long> {

   List<Repair> findByRepairDate(LocalDateTime repairDate);

   Repair findByRepairId(long  repairId);

    List<Repair> findByRepairDateAfterAndRepairDateBefore(LocalDateTime startDate ,LocalDateTime startAfter);

    List<Repair> findTop10ByRepairDateAfterAndRepairDateBeforeOrderByRepairDateAsc(LocalDateTime startDate ,LocalDateTime startAfter);


    void delete(Long id);

    Repair save(Repair repair);

}
