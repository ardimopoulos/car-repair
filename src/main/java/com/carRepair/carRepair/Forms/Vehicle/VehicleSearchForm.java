package com.carRepair.carRepair.Forms.Vehicle;

public class VehicleSearchForm {

    private static final String VAT_PATTERN = "^[0-9]{9}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_%#+.-]+@[A-Za-z0-9.-]+.[a-zA-Z]+$";

    //@NotNull(message = "{create-user.vat.null}")
    //@Pattern(regexp = VAT_PATTERN, message = "{create-user.vat.invalid}")
    private String vat;

    public String getVat() { return vat; }

    public void setVat(String vat) { this.vat = vat; }

    private String plate;

    public String getPlate() { return plate; }

    public void setPlate(String plate) { this.plate = plate; }

}
