package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Repositories.MemberRepository;
import com.carRepair.carRepair.Repositories.UserRepository;
import jdk.nashorn.internal.runtime.ECMAException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Member getCustomerByVat(String vat){

       Member member = memberRepository.findByVat(vat);


       if(member != null ) {
           System.out.println(member.getAddress() + member.getFirstname());
           return member;
       }else{
            return member;
          // throw new Exception("User not found");
       }

    }

    @Override
    public Member getCustomerByEmail(String email){

        User user = userRepository.findByEmail(email);

        Member member = memberRepository.findOne(user.getUserId());


        if(member != null ) {
            System.out.println(member.getAddress() + member.getFirstname());
            return member;
        }else{
            return member;
            // throw new Exception("User not found");
        }

    }

    public Member getMemberByVatOrMail(String vat , String email){
        Member searchMember = null;
        if( !vat.equals("") || !email.equals("") ) {
            if (!vat.equals("")) {
                 searchMember = getCustomerByVat(vat);
            } else if (!email.equals("")) {
                 searchMember = getCustomerByEmail(email);
            } else {
                System.out.println("Didn t give an email or VAT");
            }
        }else{
            System.out.println("Error message back to browser");
        }
    return searchMember;
    }


}
