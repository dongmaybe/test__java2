package com.samsung.basicsecurity.controller;

import com.samsung.basicsecurity.repositories.models.OrderDetail;
import com.samsung.basicsecurity.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order-details")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public String getAllOrderDetails(Model model) {
        List<OrderDetail> orderDetails = orderDetailService.findAll();
        model.addAttribute("orderDetails", orderDetails);
        return "order-details/index";
    }

    @GetMapping("/{id}")
    public String getOrderDetailById(@PathVariable Long id, Model model) {
        OrderDetail orderDetail = orderDetailService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid order detail Id:" + id));
        model.addAttribute("orderDetail", orderDetail);
        return "order-details/view";
    }

    @GetMapping("/new")
    public String createOrderDetailForm(Model model) {
        model.addAttribute("orderDetail", new OrderDetail());
        return "order-details/form";
    }

    @PostMapping
    public String saveOrderDetail(@ModelAttribute OrderDetail orderDetail) {
        orderDetailService.save(orderDetail);
        return "redirect:/order-details";
    }

    @GetMapping("/edit/{id}")
    public String editOrderDetailForm(@PathVariable Long id, Model model) {
        OrderDetail orderDetail = orderDetailService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid order detail Id:" + id));
        model.addAttribute("orderDetail", orderDetail);
        return "order-details/form";
    }

    @PostMapping("/{id}")
    public String updateOrderDetail(@PathVariable Long id, @ModelAttribute OrderDetail orderDetail) {
        orderDetail.setId(id);
        orderDetailService.save(orderDetail);
        return "redirect:/order-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderDetail(@PathVariable Long id) {
        orderDetailService.deleteById(id);
        return "redirect:/order-details";
    }
}
