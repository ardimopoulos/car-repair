package com.carRepair.carRepair.Services.Member;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Exceptions.InvalidCredentialsException;
import com.carRepair.carRepair.Exceptions.UserExistException;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Repositories.MemberRepository;
import com.carRepair.carRepair.Utilities.AppUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member login(String email, String password) throws AuthenticationException {

        Member member = memberRepository.findByEmail(email);

        if (member != null) {
            boolean checkPassword = AppUtilities.checkPassword(password, member.getPassword());
            if (!checkPassword) {
                throw new InvalidCredentialsException("User not found!");
            }
        } else {
            throw new InvalidCredentialsException("User not found!");
        }
        return member;
    }

    @Override
    public Member insertMember(Member member) throws UserExistException {
        Member newMember = null;
        try {
           newMember = memberRepository.save(member);
        }catch(Exception e){
            throw new UserExistException("There is already an account with same VAT or email.");
        }
        return newMember;
    }

    @Override
    public Member getMemberByVatOrMail(String vat , String email) throws UserNotFoundException {
        Member searchMember = null;
        String usingCase = "";
        if(vat != null && email != null){
            searchMember = memberRepository.findByVatAndEmail(vat, email);
            usingCase = "email"+email+" and vat"+vat;
        }else {
            searchMember = memberRepository.findByVatOrEmail(vat, email);
            if(vat == null){ usingCase = "email = "+email;}else{usingCase = "vat = "+vat;}
        }
        if (searchMember == null) {
            throw new UserNotFoundException("User not found with those credenatioals (" + usingCase+ ")");
        }
        return searchMember;
    }

    @Override
    public Member getMemberByEmail(String email) throws UserNotFoundException{
        Member m = memberRepository.findByEmail(email);
        if(m != null){return m;}else{throw new UserNotFoundException("User not found by email");}
    }

    @Override
    public Member getMemberById(Long id) throws UserNotFoundException {
        Member m =  memberRepository.findOne(id);
        if(m != null){return m;}else{throw new UserNotFoundException("User not found");}
    }

    @Override
    public Member getMemberByVat(String vat) throws UserNotFoundException{
            Member m = memberRepository.findByVat(vat);
            if(m != null){return m;}else{ throw new UserNotFoundException("User not found with VAT: " + vat); }
    }

    @Override
    public void deleteMember(Long id) throws IllegalArgumentException{

        memberRepository.delete(id);

    }
}
