package com.carRepair.carRepair.Forms.Repair;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Time;
import java.util.Date;

public class RepairForm {

    private static final String DATE_PATTERN = "^[[0-9]{4}-[0-9]{2}-[0-9]{2}]T[[0-9]{2}:[0-9]{2}]$";
    private static final String TIME_PATTERN = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
    private static final String VAT_PATTERN = "^[0-9]{9}$";

    @NotNull(message = "error")
    @Pattern(regexp = VAT_PATTERN, message = "invalid")
    private String vat;

    @NotNull(message = "error")
    @Pattern(regexp = DATE_PATTERN, message = "invalid")
    private Date date;

    @NotNull(message = "error")
    private String status;

    @NotNull(message = "error")
    private String description;

    @NotNull(message = "error")
    private boolean type;

    @NotNull(message = "error")
    private String cost;

    public RepairForm() {
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
