package com.carRepair.carRepair.Repositories;

import com.carRepair.carRepair.Domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member , Long>{

    List<Member> findAll();

    Member findOne(Long id);

    Member save(Member member);



}
