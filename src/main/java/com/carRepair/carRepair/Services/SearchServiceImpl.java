package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Repositories.MemberRepository;
import com.carRepair.carRepair.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Member getCustomerByVat(String vat) throws UserNotFoundException{
       Member member = memberRepository.findByVat(vat);
       if(member != null ) {
           System.out.println(member.getAddress() + member.getFirstname());
           return member;
       }else{ throw new UserNotFoundException("User not found"); }

    }

    @Override
    public Member getCustomerByEmail(String email) throws UserNotFoundException{
        User user = userRepository.findByEmail(email);
        if(user !=null){ Member member = memberRepository.findOne(user.getUserId());
            if(member != null ) {
                System.out.println(member.getAddress() + member.getFirstname());
                return member;
            }else{ throw new UserNotFoundException("Member not found"); }
        }else{ throw new UserNotFoundException("User not found"); }


    }

    public Member getMemberByVatOrMail(String vat , String email) throws UserNotFoundException{
        Member searchMember = null;
        if( !vat.equals("") || !email.equals("") ) {
            if (!vat.equals("")) {
                try { searchMember = getCustomerByVat(vat); }catch(UserNotFoundException userNotFound){ throw new UserNotFoundException("User Not Found!"); }
            } else if (!email.equals("")) {
                try { searchMember = getCustomerByEmail(email); }catch(UserNotFoundException userNotFound){ throw new UserNotFoundException("User Not Found!"); }
            } else { System.out.println("Didn t give an email or VAT"); }
        }else{ System.out.println("Error message back to browser"); }
    return searchMember;
    }

}
