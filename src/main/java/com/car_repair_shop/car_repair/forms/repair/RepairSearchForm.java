package com.car_repair_shop.car_repair.forms.repair;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

import static com.car_repair_shop.car_repair.properties.ValidationPatterns.PLATE_PATTERN;
import static com.car_repair_shop.car_repair.properties.ValidationPatterns.VAT_PATTERN;

@NoArgsConstructor
@Getter
@Setter
public class RepairSearchForm {

    @Pattern(regexp = VAT_PATTERN, message = "{create-user.vat.invalid}")
    private String vat;

    @Pattern(regexp = PLATE_PATTERN, message = "{create-repair.plate.invalid}" )
    private String plate;

    private String startDate;
    private String beforeDate;
    private String date;

}
