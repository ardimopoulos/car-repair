package com.carRepair.carRepair.Repositories;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Repair;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RepairRepository extends CrudRepository<Repair, Long> {

    public List<Repair> findFirst10ByDateOrderByTimeAsc(Date date);

    public List<Repair> findByDate(Date date);

    public List<Repair> findByMember(Member member);

    public List<Repair> findByDateAfterAndDateBefore(Date startDate ,Date startAfter);

    void delete(Long id);

}
