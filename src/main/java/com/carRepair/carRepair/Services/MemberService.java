package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;


public interface MemberService {

    Member getMember(Long id) throws Exception;

    Member updateMember(Long id , Member member) throws Exception;

    Member insertMember(Member member)  throws Exception;

    public void deleteMember(Long id) throws  Exception;

    Member searchMember(Long id) throws Exception;

    public Member getMemberByVat(String vat) throws UserNotFoundException;
}
