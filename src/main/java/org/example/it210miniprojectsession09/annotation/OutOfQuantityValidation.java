package org.example.it210miniprojectsession09.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.it210miniprojectsession09.model.dto.BorrowRequestDTO;
import org.example.it210miniprojectsession09.model.entity.BorrowRequest;
import org.example.it210miniprojectsession09.service.DeviceService;

public class OutOfQuantityValidation implements ConstraintValidator<OutOfQuantity, BorrowRequestDTO> {
    private DeviceService deviceService;

    public OutOfQuantityValidation(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Override
    public boolean isValid(BorrowRequestDTO value, ConstraintValidatorContext context) {
        if (value == null) return true;
        if (value.getQuantity() == null) return false;
        Integer available = deviceService.getQuantity(value.getDeviceOrLabRoomId());
        if (available == null) return false;
        boolean valid = available >= value.getQuantity();
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Không đủ số lượng")
                    .addPropertyNode("quantity")
                    .addConstraintViolation();
        }
        return valid;
    }
}
