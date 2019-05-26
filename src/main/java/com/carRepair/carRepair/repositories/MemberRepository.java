package com.carRepair.carRepair.repositories;

import com.carRepair.carRepair.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{

    List<Member> findAll();

    Member findOne(Long id);

    Member findByVat(String vat);

    Member findByVatOrEmail(String vat, String email);

    Member findByVatAndEmail(String vat, String email);

    Member findByEmail(String email);

    Member save(Member member);
}
