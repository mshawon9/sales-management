package com.wsd.sales.controller;

import com.wsd.sales.model.OrderModel;
import com.wsd.sales.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    @GetMapping("/current-day")
    public List<OrderModel> getCurrentDayOrders() {
        LOGGER.info("calling api /api/order/current-day");
        return orderService.getOrderListOfCurrentDay();
    }

    @GetMapping("/total-amount-current-day")
    public Double getTotalAmountCurrentDay() {
        LOGGER.info("calling api /api/order/total-amount-current-day");
        return orderService.getTotalSaleAmountOfCurrentDay();
    }

    @GetMapping("/max-sale-date")
    public ResponseEntity<List<LocalDate>> getMaxSaleDate(@RequestParam String from, @RequestParam String to) {
        try {
            LOGGER.info("calling api /api/order/max-sale-date");
            List<LocalDate> maxSaleDate = orderService.getMaximumSaleDayByTimeRange(from, to);
            return new ResponseEntity<>(maxSaleDate, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("error getMaxSaleDate(): " + e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    }
}
