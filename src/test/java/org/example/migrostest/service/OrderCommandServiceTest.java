package org.example.migrostest.service;

import org.example.migrostest.datahelper.MigrosTestUnitTestBase;
import org.example.migrostest.domain.Order;
import org.example.migrostest.dto.OrderDTO;
import org.example.migrostest.repository.OrderRepository;
import org.example.migrostest.service.impl.OrderCommandServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class OrderCommandServiceTest extends MigrosTestUnitTestBase {

    private OrderCommandService orderCommandService;

    @Mock
    private OrderRepository orderRepository;

    @Before
    public void setup(){
        orderCommandService = new OrderCommandServiceImpl(orderRepository);
    }

    @Test
    public void createOrder() {
        Order order = doFactory.order();

        Mockito.when(orderRepository.save(Mockito.any())).thenReturn(order);

        OrderDTO response = orderCommandService.createOrder(order.toDTO());

        Assert.assertEquals(order.getId(), response.getId());
    }
}