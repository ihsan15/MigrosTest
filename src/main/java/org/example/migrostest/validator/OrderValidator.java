package org.example.migrostest.validator;

import org.example.migrostest.api.request.CreateOrderRequest;
import org.example.migrostest.dto.OrderDTO;
import org.example.migrostest.dto.OrderProductDTO;
import org.example.migrostest.validator.annotation.ValidOrder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.OffsetDateTime;
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
        OrderDTO order = value.getOrder();
        validationList.add(isValid(context, "Order Date Must Be Greater Than Now.", order.getOrderDate().compareTo(OffsetDateTime.now()) >= 1));
        validationList.add(isValid(context, "At least one product must be selected.", order.getProducts() != null && !order.getProducts().isEmpty()));

        if(order.getProducts() != null){
            for (OrderProductDTO product : order.getProducts()) {
                // TODO: product name instead of product Id
                validationList.add(isValid(context, "The selected product" + product.getProductId() + " quantity must be greater than zero.", product.getQuantity() > 0));
            }
        }
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
