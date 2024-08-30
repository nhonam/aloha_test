package com.aloha.examtest.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DobValidator implements ConstraintValidator<DobContraint, LocalDate> {

    private int min;

    @Override
    public void initialize(DobContraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

        long years = ChronoUnit.YEARS.between(value, LocalDate.now());

        return years >= min;
    }
}
