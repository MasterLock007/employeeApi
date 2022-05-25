package com.employees.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodesEnum {
    VALIDATION_ERROR("VALERR001","Error in validations verify the data"),
    AGE_ERROR("ERROR001","The employee is not of legal age"),
    HOURS_ERROR("VALERR002","Can´t add more than 20 hours"),
    RANGE_ERROR("RANGERR001","the end date is greater than the start date"),
    RANGE_ERROR_001("RANGERR002","No data in range");
    private String code;
    private String message;
}
