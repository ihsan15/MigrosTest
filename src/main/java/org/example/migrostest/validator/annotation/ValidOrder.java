package org.example.migrostest.validator.annotation;

import org.example.migrostest.validator.OrderValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {OrderValidator.class})
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidOrder {

    Class<?>[] groups() default {};

    String message() default "error";

    Class<? extends Payload>[] payload() default {};
}
