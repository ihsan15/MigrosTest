package org.example.migrostest.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.migrostest.domain.base.MigrosTestBaseEntity;
import org.example.migrostest.dto.OrderDTO;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "order_info")
@Where(clause = "status = 1")
@Getter
@Setter
public class Order extends MigrosTestBaseEntity {

    private Long customerId;

    private OffsetDateTime orderDate;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<OrderProduct> products;

    public OrderDTO toDTO(){
        OrderDTO order = new OrderDTO();
        order.setId(getId());
        order.setStatus(getStatus());
        order.setCustomerId(getCustomerId());
        order.setOrderDate(getOrderDate());
        if(getProducts() != null){
            order.setProducts(getProducts().stream().map(OrderProduct::toDTO).collect(Collectors.toSet()));
        }
        return order;
    }

    public Order fromDTO(OrderDTO orderDTO) {
        setId(orderDTO.getId());
        this.customerId = orderDTO.getCustomerId();
        this.orderDate = orderDTO.getOrderDate();
        this.products = orderDTO.getProducts().stream().map(o -> new OrderProduct().fromDTO(o, this)).collect(Collectors.toSet());
        return this;
    }
}
