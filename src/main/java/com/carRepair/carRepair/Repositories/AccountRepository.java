package com.carRepair.carRepair.Repositories;

import com.carRepair.carRepair.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<User , Long> {

    User findByEmailAndPassword(String email, String password);

}
