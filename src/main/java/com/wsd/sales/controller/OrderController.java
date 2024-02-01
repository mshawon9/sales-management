package com.wsd.sales.controller;

import com.wsd.sales.model.OrderModel;
import com.wsd.sales.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/current-day")
    public List<OrderModel> getCurrentDayOrders() {

        return orderService.getOrderListOfCurrentDay();
    }
}
