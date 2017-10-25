package com.carRepair.carRepair.Services.Member;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public Member insertMember(Member member) throws Exception{
        Member newMember = memberRepository.save(member);
        if(newMember == null){
            throw new Exception("User already exists");
        }
        return newMember;
    }

    public Member getMemberByVatOrMail(String vat , String email) throws UserNotFoundException {
        Member searchMember = null;
        try {
            if(!vat.equals("") && !email.equals("")){
                searchMember = memberRepository.findByVatAndEmail(vat, email);
            }else {
                searchMember = memberRepository.findByVatOrEmail(vat, email);
            }
            if (searchMember == null || (vat.equals("") && email.equals(""))) {
                throw new UserNotFoundException("User not found with those credenatioals");
            }
        }catch(Exception e){
            throw new UserNotFoundException("User not found");
        }

        return searchMember;
    }

/*
    @Override
    public Member getMemberByVat(String vat) throws Exception {
        Member member = memberRepository.findByVat(vat);
        if(member == null){
            throw new Exception("Member not found!");
        }
        return member;
    }*/

    @Override
    public Member getMemberById(Long id) throws Exception {
        return memberRepository.findOne(id);
    }



    public Member updateMember(Long id , Member member){
       Member m = memberRepository.save(member);
        return m;
    }

    @Override
    public Member getMemberByVat(String vat) throws UserNotFoundException{
            Member m = memberRepository.findByVat(vat);
            if(m != null){return m;}else{ throw new UserNotFoundException("User not found with VAT: " + vat); }
    }

    public void deleteMember(Long id){ memberRepository.delete(id); }

    public Member searchMember(Long id){ Member member = memberRepository.findOne(id); return member; }



}
