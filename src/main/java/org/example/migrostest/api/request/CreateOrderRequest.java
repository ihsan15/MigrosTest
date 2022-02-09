package org.example.migrostest.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.example.migrostest.dto.OrderDTO;
import org.example.migrostest.validator.annotation.ValidOrder;

@Getter
@Setter
@ValidOrder
@ApiModel
public class CreateOrderRequest {
    @ApiModelProperty
    private OrderDTO order;
}
