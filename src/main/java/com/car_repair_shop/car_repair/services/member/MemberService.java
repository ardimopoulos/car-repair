package com.car_repair_shop.car_repair.services.member;

import com.car_repair_shop.car_repair.domain.Member;
import com.car_repair_shop.car_repair.exceptions.UserExistException;
import com.car_repair_shop.car_repair.exceptions.UserNotFoundException;
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
