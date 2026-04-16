package org.example.it210miniprojectsession09.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {StartDateLessThanEndDateValidation.class})
public @interface StartDateLessThanEndDateValid {
    String message() default "Ngày bắt đầu phải nhỏ hơn ngày kết thúc";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
