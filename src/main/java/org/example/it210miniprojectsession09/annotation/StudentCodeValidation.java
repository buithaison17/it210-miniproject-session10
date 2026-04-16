package org.example.it210miniprojectsession09.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StudentCodeValidation implements ConstraintValidator<StudentCodeValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return value.startsWith("VN_");
    }
}
