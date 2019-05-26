package com.carRepair.carRepair.forms.repair;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
public class RepairSearchForm {

    private static final String VAT_PATTERN = "^[0-9]{9}$";
    private static final String PLATE_PATTERN = "^[a-zA-Z]{3}-[1-9]{4}$";

    @Pattern(regexp = VAT_PATTERN, message = "{create-user.vat.invalid}")
    private String vat;

    @Pattern(regexp = PLATE_PATTERN, message = "{create-repair.plate.invalid}" )
    private String plate;

    private String startDate;
    private String beforeDate;
    private String date;

}
