package org.example.migrostest.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.migrostest.domain.Order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class OrderProductDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;
}
