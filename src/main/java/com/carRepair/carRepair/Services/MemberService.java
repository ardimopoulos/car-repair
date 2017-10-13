package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Repositories.MemberRepository;
import com.carRepair.carRepair.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member addUser(Member member){
        memberRepository.save(member);
        return member;
    }


}
