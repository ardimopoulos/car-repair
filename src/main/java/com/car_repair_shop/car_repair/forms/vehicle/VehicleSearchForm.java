package com.car_repair_shop.car_repair.forms.vehicle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class VehicleSearchForm {

    private static final String VAT_PATTERN = "^[0-9]{9}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_%#+.-]+@[A-Za-z0-9.-]+.[a-zA-Z]+$";

    private String vat;
    private String plate;
}
