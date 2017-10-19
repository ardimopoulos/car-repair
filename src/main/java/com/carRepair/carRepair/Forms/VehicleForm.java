package com.carRepair.carRepair.Forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class VehicleForm {

    private static final String PLATE_PATTERN = "[a-zA-Z]{3}-[0-9]{4}";
    private static final String BRAND_PATTERN = "[a-zA-Z0-9\\s]+";
    private static final String MODEL_PATTERN = "[a-zA-Z0-9\\s]+";
    private static final String COLOR_PATTERN = "[a-zA-Z\\s]+";
    private static final String YEAR_PATTERN = "[0-9]{2}/[0-9]{2}/[1-9]{4}";

    @NotNull(message = "{create-user.vat.null}")
    @Pattern(regexp = PLATE_PATTERN, message = "{create-user.vat.invalid}")
    private String plate;

    @NotNull(message = "{create-user.vat.null}")
    @Pattern(regexp = BRAND_PATTERN, message = "{create-user.vat.invalid}")
    private String brand;

    @NotNull(message = "{create-user.vat.null}")
    @Pattern(regexp = MODEL_PATTERN, message = "{create-user.vat.invalid}")
    private String model;

    @NotNull(message = "{create-user.vat.null}")
    @Pattern(regexp = COLOR_PATTERN, message = "{create-user.vat.invalid}")
    private String color;

    @NotNull(message = "{create-user.vat.null}")
    @Pattern(regexp = YEAR_PATTERN, message = "{create-user.vat.invalid}")
    private Date yearOfModel;

    public VehicleForm() {
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String moden) {
        this.model = moden;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getYearOfModel() {
        return yearOfModel;
    }

    public void setYearOfModel(Date yearOfModel) {
        this.yearOfModel = yearOfModel;
    }
}
