package com.car_repair_shop.car_repair.properties;

public class ValidationPatterns {
    
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_%#+.-]+@[A-Za-z0-9.-]+.[a-zA-Z]+$";
    public static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";
    public static final String PLATE_PATTERN = "^[a-zA-Z]{3}-[1-9]{4}$";
    public static final String ADDRESS_PATTERN = "^[a-zA-Z0-9\\s]+$";
    public static final String COST_PATTERN = "^[0-9]+[.]{1}[0-9]+$";
    public static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";
    public static final String BRAND_PATTERN = "^[a-zA-Z0-9\\s]+$";
    public static final String MODEL_PATTERN = "^[a-zA-Z0-9\\s]+$";
    public static final String YEAR_PATTERN = "^[12]{1}[0-9]{3}$";
    public static final String COLOR_PATTERN = "^[a-zA-Z\\s]+$";
    public static final String NAME_PATTERN = "^[a-zA-Z]+$";
    public static final String VAT_PATTERN = "^[0-9]{9}$";
    public static final String STATUS_PATTERN = "^[012]$";
    public static final int PASSWORD_MINIMUM_SIZE = 8;
    public static final String DESC_PATTERN = "^.+$";
    public static final String TYPE_PATTERN = "^.+$";

    private ValidationPatterns() {}
}
