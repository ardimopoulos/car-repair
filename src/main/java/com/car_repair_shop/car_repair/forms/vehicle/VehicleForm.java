package com.car_repair_shop.car_repair.forms.vehicle;

import com.car_repair_shop.car_repair.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.car_repair_shop.car_repair.properties.ValidationPatterns.*;

@NoArgsConstructor
@Getter
@Setter
public class VehicleForm {

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

    public VehicleForm(String vehicleId, String vat, String plate, String brand, String model, String color, String yearOfModel) {
        this.vehicleId = vehicleId;
        this.vat = vat;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearOfModel = yearOfModel;
    }
}
