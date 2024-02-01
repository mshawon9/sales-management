package com.wsd.sales.service.impl;

import com.wsd.sales.model.OrderModel;
import com.wsd.sales.repository.OrderRepository;
import com.wsd.sales.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public List<OrderModel> getOrderListOfCurrentDay() {

        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        LocalDateTime endOfDay = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);

        return orderRepository.findByOrderAtBetween(startOfDay, endOfDay);
    }

    @Override
    public List<OrderModel> getOrderListOfSingleCustomer() {
        return null;
    }

    @Override
    public double getTotalSaleAmountOfCurrentDay() {
        return 0;
    }

    @Override
    public String getMaximumSaleDayByTimeRange(LocalDateTime from, LocalDateTime to) {
        return null;
    }
}
