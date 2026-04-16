package org.example.it210miniprojectsession09.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.it210miniprojectsession09.model.dto.BorrowRequestDTO;

public class StartDateLessThanEndDateValidation implements ConstraintValidator<StartDateLessThanEndDateValid, BorrowRequestDTO> {
    @Override
    public boolean isValid(BorrowRequestDTO value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate("Ngày kết thúc phải lớn hơn ngày bắt đầu")
                .addPropertyNode("endDate")
                .addConstraintViolation();
        if (value.getStartDate() == null || value.getEndDate() == null) return false;
        return value.getStartDate().isBefore(value.getEndDate());
    }
}
