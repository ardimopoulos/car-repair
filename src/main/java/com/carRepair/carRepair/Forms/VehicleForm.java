package com.carRepair.carRepair.Forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class VehicleForm {

    private static final String PLATE_PATTERN = "^[a-zA-Z]{3}-[0-9]{4}$";
    private static final String BRAND_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String MODEL_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String COLOR_PATTERN = "^[a-zA-Z\\s]+$";
    private static final String YEAR_PATTERN = "^[0-9]{2}/[0-9]{2}/[1-9]{4}$";
    private static final String VAT_PATTERN = "^[0-9]{9}$";
    private static final String ID_PATTERN = "^[0-9]{9}$";

   // @NotNull(message = "error")
   // @Pattern(regexp = VAT_PATTERN, message = "error")
    private String vat;

    @NotNull(message = "error")
   // @Pattern(regexp = PLATE_PATTERN, message = "error")
    private String plate;

    @NotNull(message = "error")
   // @Pattern(regexp = BRAND_PATTERN, message = "error")
    private String brand;

    @NotNull(message = "error")
   // @Pattern(regexp = MODEL_PATTERN, message = "{create-user.vat.invalid}")
    private String model;

    @NotNull(message = "error")
  //  @Pattern(regexp = COLOR_PATTERN, message = "{create-user.vat.invalid}")
    private String color;

    @NotNull(message = "error")
 //   @Pattern(regexp = YEAR_PATTERN, message = "{create-user.vat.invalid}")
    private String yearOfModel;

    //TODO add vehicle radio button fields

    public VehicleForm() {
    }



    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
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

    public String getYearOfModel() {
        return yearOfModel;
    }

    public void setYearOfModel(String yearOfModel) {
        this.yearOfModel = yearOfModel;
    }
}
