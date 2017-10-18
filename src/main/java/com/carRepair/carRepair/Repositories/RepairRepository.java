package com.carRepair.carRepair.Repositories;

import com.carRepair.carRepair.Domain.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RepairRepository extends CrudRepository<Service , Long> {

    public List<Service> findByDateOrderByTimeAsc(Date date);

}
