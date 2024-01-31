package com.wsd.sales.service;

import com.wsd.sales.model.OrderModel;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    List<OrderModel> getOrderListOfCurrentDay();
    List<OrderModel> getOrderListOfSingleCustomer();
    double getTotalSaleAmountOfCurrentDay();

    String getMaximumSaleDayByTimeRange(LocalDateTime from, LocalDateTime to);
}
