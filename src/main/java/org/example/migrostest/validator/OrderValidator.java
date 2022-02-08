package org.example.migrostest.validator;

import org.example.migrostest.api.request.CreateOrderRequest;
import org.example.migrostest.validator.annotation.ValidOrder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class OrderValidator implements ConstraintValidator<ValidOrder, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value instanceof CreateOrderRequest){
            return isValidForCreateOrderRequest(context, (CreateOrderRequest) value);
        }
        return true;
    }

    private boolean isValidForCreateOrderRequest(ConstraintValidatorContext context, CreateOrderRequest value) {
        Set<Boolean> validationList = new HashSet<>();
       validationList.add(isValid(context, "", value != null));
        return !validationList.contains(false);
    }

    private boolean isValid(ConstraintValidatorContext context, String message, boolean isValid) {
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        }
        return isValid;
    }

}
