package com.car_repair_shop.car_repair.services.member;

import com.car_repair_shop.car_repair.domain.Member;
import com.car_repair_shop.car_repair.exceptions.InvalidCredentialsException;
import com.car_repair_shop.car_repair.exceptions.UserExistException;
import com.car_repair_shop.car_repair.exceptions.UserNotFoundException;
import com.car_repair_shop.car_repair.repositories.MemberRepository;
import com.car_repair_shop.car_repair.utilities.AppUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member login(String email, String password) throws AuthenticationException {

        Member member = memberRepository.findByEmail(email);

        if (member != null) {
            boolean checkPassword = AppUtilities.checkPassword(password, member.getPassword());

            if (!checkPassword) {
                throw new InvalidCredentialsException("user not found!");
            }

        } else {
            throw new InvalidCredentialsException("user not found!");
        }

        return member;
    }

    @Override
    public Member insertMember(Member member) throws UserExistException {
        Member newMember;

        try {
           newMember = memberRepository.save(member);

        } catch (Exception e) {
            throw new UserExistException("There is already an account with same VAT or email.");
        }

        return newMember;
    }

    @Override
    public Member getMemberByVatOrMail(String vat , String email) throws UserNotFoundException {
        Member searchMember;
        String usingCase;

        if (vat != null && email != null) {
            searchMember = memberRepository.findByVatAndEmail(vat, email);
            usingCase = "email"+email+" and vat"+vat;

        } else {
            searchMember = memberRepository.findByVatOrEmail(vat, email);

            if(vat == null) {
                usingCase = "email = "+email;

            } else {
                usingCase = "vat = "+vat;
            }
        }

        if (searchMember == null) {
            throw new UserNotFoundException("user not found with those credentials (" + usingCase+ ")");
        }

        return searchMember;
    }

    @Override
    public Member getMemberByEmail(String email) throws UserNotFoundException{
        Member member = memberRepository.findByEmail(email);

        if (member != null) {
            return member;

        } else {
            throw new UserNotFoundException("user not found by email");
        }
    }

    @Override
    public Member getMemberById(Long id) throws UserNotFoundException {
        Member member =  memberRepository.findOne(id);

        if(member != null) {
            return member;

        } else {
            throw new UserNotFoundException("user not found");
        }
    }

    @Override
    public Member getMemberByVat(String vat) throws UserNotFoundException{
        Member member = memberRepository.findByVat(vat);

        if(member != null) {
            return member;

        } else {
            throw new UserNotFoundException("user not found with VAT: " + vat);
        }
    }

    @Override
    public void deleteMember(Long id) throws IllegalArgumentException{
        memberRepository.delete(id);
    }
}
