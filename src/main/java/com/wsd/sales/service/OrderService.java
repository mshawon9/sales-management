package com.wsd.sales.service;

import com.wsd.sales.model.OrderModel;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    List<OrderModel> getOrderListOfCurrentDay();

    Double getTotalSaleAmountOfCurrentDay();

    List<LocalDate> getMaximumSaleDayByTimeRange(String from, String to) throws ParseException;
}
