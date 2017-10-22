package com.carRepair.carRepair.Forms.Repair;

import org.apache.tomcat.jni.Local;

import javax.print.DocFlavor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RepairSearchForm {

    private static final String VAT_PATTERN = "^[0-9]{9}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_%#+.-]+@[A-Za-z0-9.-]+.[a-zA-Z]+$";

    private String startDate;

    private String beforeDate;

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate;}

    public String getBeforeDate() { return beforeDate; }

    public void setBeforeDate(String beforeDate) { this.beforeDate = beforeDate; }

    private String date;


    public String getDate() {
        //LocalDate localDate = formatLocalDate("yyyy/MM/dd" , this.date);

        return this.date; }

    public void setDate(String date) { this.date = date; }

    //@NotNull(message = "{create-user.vat.null}")
    //@Pattern(regexp = VAT_PATTERN, message = "{create-user.vat.invalid}")
    private String vat;

    public String getVat() { return vat; }

    public void setVat(String vat) { this.vat = vat; }

    private String plate;

    public String getPlate() { return plate; }

    public void setPlate(String plate) { this.plate = plate; }
}
