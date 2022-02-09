package org.example.migrostest.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.migrostest.domain.base.MigrosTestBaseEntity;
import org.example.migrostest.dto.OrderProductDTO;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Where(clause = "status = 1")
@Getter
@Setter
public class OrderProduct extends MigrosTestBaseEntity {

    @ManyToOne
    private Order order;

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;

    public OrderProductDTO toDTO(){
        OrderProductDTO orderProduct = new OrderProductDTO();
        orderProduct.setId(getId());
        orderProduct.setProductId(getProductId());
        orderProduct.setQuantity(getQuantity());
        return orderProduct;
    }

    public OrderProduct fromDTO(OrderProductDTO orderProductDTO, Order order) {
        setId(orderProductDTO.getId());
        this.order = order;
        this.productId = getProductId();
        this.quantity = getQuantity();
        return this;
    }
}
