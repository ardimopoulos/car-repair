package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;

public interface SearchService {

    public Member getCustomerByEmail(String email);
    public Member getCustomerByVat(String vat);
    public Member getMemberByVatOrMail(String vat , String email);

}
