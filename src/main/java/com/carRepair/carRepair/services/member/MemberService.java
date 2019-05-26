package com.carRepair.carRepair.services.member;

import com.carRepair.carRepair.domain.Member;
import com.carRepair.carRepair.exceptions.UserExistException;
import com.carRepair.carRepair.exceptions.UserNotFoundException;
import org.springframework.security.core.AuthenticationException;


public interface MemberService {

    Member getMemberByVatOrMail(String vat , String email) throws UserNotFoundException;

    Member getMemberById(Long id) throws UserNotFoundException;

    Member getMemberByVat(String vat) throws UserNotFoundException;

    Member insertMember(Member member)  throws UserExistException;

    Member login(String username, String password) throws AuthenticationException;

    Member getMemberByEmail(String email) throws UserNotFoundException;

    void deleteMember(Long id) throws IllegalArgumentException;
}
