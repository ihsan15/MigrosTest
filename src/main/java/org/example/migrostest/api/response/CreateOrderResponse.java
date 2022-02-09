package org.example.migrostest.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.migrostest.dto.OrderDTO;

@Getter
@Setter
@AllArgsConstructor
@ApiModel
public class CreateOrderResponse {

    @ApiModelProperty
    private OrderDTO order;
}
