package com.samsung.basicsecurity.services;

import com.samsung.basicsecurity.repositories.OrderDetailsRepository;
import com.samsung.basicsecurity.repositories.OrderRepository;
import com.samsung.basicsecurity.repositories.models.Order;
import com.samsung.basicsecurity.repositories.models.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public void createOrder(Order order, List<OrderDetail> orderDetailsList) {
        orderRepository.save(order);
        orderDetailsList.forEach(orderDetailsRepository::save);
    }

}
