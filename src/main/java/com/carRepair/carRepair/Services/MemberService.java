package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void insertMember(Member member){ memberRepository.save(member); }

    public void updateMember(Long id , Member member){ memberRepository.save(member); }

    public void deleteMember(Long id){ memberRepository.delete(id); }

    public Member searchMember(Long id){ Member member = memberRepository.findOne(id); return member; }



}
