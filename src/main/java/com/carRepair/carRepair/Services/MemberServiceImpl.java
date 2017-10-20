package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;



    public Member insertMember(Member member){
        Member m = memberRepository.save(member);
        return m;
    }

    @Override
    public Member getMember(Long id) throws Exception {
        return memberRepository.findOne(id);
    }

    public Member updateMember(Long id , Member member){
       Member m = memberRepository.save(member);
        return m;
    }

    public void deleteMember(Long id){ memberRepository.delete(id); }

    public Member searchMember(Long id){ Member member = memberRepository.findOne(id); return member; }



}
