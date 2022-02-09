package org.example.migrostest.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.migrostest.dto.base.MigrosTestBaseDTO;

@Getter
@Setter
public class OrderProductDTO extends MigrosTestBaseDTO {

    private OrderDTO order;

    private Long productId;

    private Integer quantity;
}
