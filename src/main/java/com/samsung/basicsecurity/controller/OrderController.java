package com.samsung.basicsecurity.controller;

import com.samsung.basicsecurity.repositories.models.Order;
import com.samsung.basicsecurity.repositories.models.OrderDetail;
import com.samsung.basicsecurity.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/submit")
    public String submitOrder(@ModelAttribute Order order, @RequestParam List<OrderDetail> orderDetails) {
        orderService.createOrder(order, orderDetails);
        return "redirect:/order/confirmation";
    }
}