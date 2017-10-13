package com.carRepair.carRepair.Repositories;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member , Long>{

    List<Member> findAll();

    Member findOne(Long id);



}
