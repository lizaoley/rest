package com.liza.valid.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CarNumberValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CarNumber {

    public String value() default "RUS";
    public String message() default "Car number must ends with RUS";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {}; // эта и предыдущая строка пишутся по умолчанию

}
