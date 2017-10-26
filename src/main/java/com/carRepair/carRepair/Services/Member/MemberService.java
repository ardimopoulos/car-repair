package com.carRepair.carRepair.Services.Member;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Exceptions.UserExistException;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;


public interface MemberService {

    Member getMemberByVatOrMail(String vat , String email) throws UserNotFoundException;

    Member getMemberById(Long id) throws UserNotFoundException;

    Member getMemberByVat(String vat) throws UserNotFoundException;

    Member insertMember(Member member)  throws UserExistException;

    Member login(String username, String password) throws AuthenticationException;

    Member getMemberByEmail(String email) throws UserNotFoundException;

    void deleteMember(Long id) throws IllegalArgumentException;
}
