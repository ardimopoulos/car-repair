package com.carRepair.carRepair.Forms.Vehicle;

import com.carRepair.carRepair.Domain.Member;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class VehicleForm {

    private static final String PLATE_PATTERN = "^[a-zA-Z]{3}-[0-9]{4}$";
    private static final String BRAND_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String MODEL_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String COLOR_PATTERN = "^[a-zA-Z\\s]+$";
    private static final String YEAR_PATTERN = "^[12]{1}[0-9]{3}$";
    private static final String VAT_PATTERN = "^[0-9]{9}$";

    private String vehicleId;

    @NotNull(message = "{create-vehicle.vat.null}")
    @Pattern(regexp = VAT_PATTERN, message = "{create-vehicle.vat.invalid}")
    private String vat;

    @NotNull(message = "{create-vehicle.plate.null}")
    @Pattern(regexp = PLATE_PATTERN, message = "{create-vehicle.plate.invalid}")
    private String plate;

    @NotNull(message = "{create-vehicle.brand.null}")
    @Pattern(regexp = BRAND_PATTERN, message = "{create-vehicle.brand.invalid}")
    private String brand;

    @NotNull(message = "{create-vehicle.model.null}")
    @Pattern(regexp = MODEL_PATTERN, message = "{create-vehicle.model.invalid}")
    private String model;

    @NotNull(message = "{create-vehicle.color.null}")
    @Pattern(regexp = COLOR_PATTERN, message = "{create-vehicle.color.invalid}")
    private String color;

    @NotNull(message = "{create-vehicle.year.null}")
    @Pattern(regexp = YEAR_PATTERN, message = "{create-vehicle.year.invalid}")
    private String yearOfModel;

    private Member member;

    public VehicleForm() {
    }

    public VehicleForm(String vehicleId, String vat, String plate, String brand, String model, String color, String yearOfModel) {
        this.vehicleId = vehicleId;
        this.vat = vat;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearOfModel = yearOfModel;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
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
