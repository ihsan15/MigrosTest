package org.example.migrostest.datahelper;

import org.example.migrostest.domain.Order;
import org.example.migrostest.domain.OrderProduct;
import org.example.migrostest.dto.OrderDTO;
import org.example.migrostest.dto.OrderProductDTO;

import java.security.SecureRandom;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

public class MigrosTestDTOFactory {
	private final SecureRandom rand;

	public MigrosTestDTOFactory(SecureRandom rand) {
		this.rand = rand;
	}

	public OrderDTO order() {
		OrderDTO order = new OrderDTO();
		order.setCustomerId(1L);
		order.setId(2L);
		order.setOrderDate(OffsetDateTime.now());
		order.setStatus(1);
		order.setProducts(products(order));
		return order;
	}

	private Set<OrderProductDTO> products(OrderDTO order) {
		Set<OrderProductDTO> products = new HashSet<>();
		products.add(product(order));
		return products;
	}

	private OrderProductDTO product(OrderDTO order) {
		OrderProductDTO orderProduct = new OrderProductDTO();
		orderProduct.setId(1L);
		orderProduct.setProductId(2L);
		orderProduct.setQuantity(1);
		orderProduct.setOrder(order);
		return orderProduct;
	}

}
