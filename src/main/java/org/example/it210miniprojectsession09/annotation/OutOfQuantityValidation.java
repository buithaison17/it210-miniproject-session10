package org.example.it210miniprojectsession09.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.it210miniprojectsession09.model.entity.BorrowRequest;
import org.example.it210miniprojectsession09.service.DeviceService;

public class OutOfQuantityValidation implements ConstraintValidator<OutOfQuantity, BorrowRequest> {
    private DeviceService deviceService;

    public OutOfQuantityValidation(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Override
    public boolean isValid(BorrowRequest value, ConstraintValidatorContext context) {
        Integer quantity = deviceService.getQuantity(value.getDeviceOrLabRoomId());
        if (value.getQuantity() == null) return false;
        if (quantity == null) return false;
        context.buildConstraintViolationWithTemplate("Không đủ số lượng").addPropertyNode("quantity").addConstraintViolation();
        return quantity >= value.getQuantity();
    }
}
