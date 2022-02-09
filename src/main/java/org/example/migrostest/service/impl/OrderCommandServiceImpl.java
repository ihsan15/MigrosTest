package org.example.migrostest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.migrostest.domain.Order;
import org.example.migrostest.dto.OrderDTO;
import org.example.migrostest.repository.OrderRepository;
import org.example.migrostest.service.OrderCommandService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCommandServiceImpl implements OrderCommandService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order().fromDTO(orderDTO);
        return orderRepository.save(order).toDTO();
    }
}
