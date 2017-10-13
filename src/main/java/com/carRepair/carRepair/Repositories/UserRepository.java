package com.carRepair.carRepair.Repositories;

import com.carRepair.carRepair.Domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long>{

    List<User> findAll();

    User findOne(Long id);




}
