package com.carRepair.carRepair.Forms.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SearchForm {

    private String email;

    private String vat;

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getVat() { return vat; }

    public void setVat(String vat) { this.vat = vat; }
}
