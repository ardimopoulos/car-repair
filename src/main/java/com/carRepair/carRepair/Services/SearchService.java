package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;

public interface SearchService {

    public Member getCustomerByEmail(String email)throws UserNotFoundException;
    public Member getCustomerByVat(String vat) throws UserNotFoundException;
    public Member getMemberByVatOrMail(String vat , String email);

}
