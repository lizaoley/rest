package com.liza.valid.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CarNumberValidator implements ConstraintValidator<CarNumber, String> {

    private String countryCode;

    @Override
    public void initialize(CarNumber cn) {
        countryCode = cn.value();
    }

    @Override
    public boolean isValid(String cn, ConstraintValidatorContext constraintValidatorContext) {
        if (cn == null || countryCode == null) {
            return false;
        }
        boolean result = cn.toUpperCase().endsWith(countryCode); // сделали так, чтобы не было зависимости от больших или маленьких букв
        return result;
    }
} 