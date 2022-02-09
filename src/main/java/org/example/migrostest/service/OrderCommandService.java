package org.example.migrostest.service;

import org.example.migrostest.dto.OrderDTO;

public interface OrderCommandService {

    OrderDTO createOrder(OrderDTO orderDTO);
}
