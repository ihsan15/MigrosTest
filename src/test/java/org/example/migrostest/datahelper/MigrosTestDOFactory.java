package org.example.migrostest.datahelper;

import org.example.migrostest.domain.Order;
import org.example.migrostest.domain.OrderProduct;

import java.security.SecureRandom;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


public class MigrosTestDOFactory {

    private final SecureRandom rand;

    public MigrosTestDOFactory(SecureRandom rand) {
        this.rand = rand;
    }

    public Order order() {
        Order order = new Order();
        order.setCustomerId(1L);
        order.setId(2L);
        order.setOrderDate(OffsetDateTime.now());
        order.setStatus(1);
        order.setProducts(products(order));
        return order;
    }

    private Set<OrderProduct> products(Order order) {
        Set<OrderProduct> products = new HashSet<>();
        products.add(product(order));
        return products;
    }

    private OrderProduct product(Order order) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(1L);
        orderProduct.setProductId(2L);
        orderProduct.setQuantity(1);
        orderProduct.setOrder(order);
        return orderProduct;
    }
}
