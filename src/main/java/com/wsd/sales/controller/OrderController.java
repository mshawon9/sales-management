package com.wsd.sales.controller;

import com.wsd.sales.model.OrderModel;
import com.wsd.sales.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @GetMapping("/total-amount-current-day")
    public Double getTotalAmountCurrentDay() {

        return orderService.getTotalSaleAmountOfCurrentDay();
    }

    @GetMapping("/max-sale-date")
    public ResponseEntity<List<LocalDate>> getMaxSaleDate(@RequestParam String from, @RequestParam String to) {
        try {
            List<LocalDate> maxSaleDate = orderService.getMaximumSaleDayByTimeRange(from, to);
            return new ResponseEntity<>(maxSaleDate, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    }
}
