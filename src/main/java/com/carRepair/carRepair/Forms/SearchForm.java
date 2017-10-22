package com.carRepair.carRepair.Forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SearchForm {
    private static final String VAT_PATTERN = "^[0-9]{9}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_%#+.-]+@[A-Za-z0-9.-]+.[a-zA-Z]+$";

    //@NotNull(message = "{create-user.email.null}")
    //@Pattern(regexp = EMAIL_PATTERN, message = "{create-user.email.invalid}")
    private String email;

    //@NotNull(message = "{create-user.vat.null}")
    //@Pattern(regexp = VAT_PATTERN, message = "{create-user.vat.invalid}")
    private String vat;

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getVat() { return vat; }

    public void setVat(String vat) { this.vat = vat; }
}
