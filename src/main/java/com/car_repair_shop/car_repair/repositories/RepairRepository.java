package com.car_repair_shop.car_repair.repositories;

import com.car_repair_shop.car_repair.domain.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepairRepository extends CrudRepository<Repair, Long> {

   Repair findByRepairId(long repairId);

    List<Repair> findByRepairDateAfterAndRepairDateBefore(LocalDateTime startDate ,LocalDateTime startAfter);

    List<Repair> findTop10ByRepairDateBetweenOrderByRepairDateAsc(LocalDateTime startDate ,LocalDateTime startAfter);

    void delete(Long id);

    Repair save(Repair repair);
}
