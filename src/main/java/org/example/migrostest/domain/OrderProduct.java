package org.example.migrostest.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.migrostest.dto.OrderProductDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;

    public OrderProductDTO toDTO(){
        OrderProductDTO orderProduct = new OrderProductDTO();
        orderProduct.setId(getId());
        orderProduct.setOrder(getOrder());
        orderProduct.setProductId(getProductId());
        orderProduct.setQuantity(getQuantity());
        return orderProduct;
    }

    public OrderProduct fromDTO(OrderProductDTO orderProductDTO, Order order) {
        this.id = orderProductDTO.getId();
        this.order = order;
        this.productId = getProductId();
        this.quantity = getQuantity();
        return this;
    }
}
