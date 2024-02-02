package com.wsd.sales.service.impl;

import com.wsd.sales.model.OrderModel;
import com.wsd.sales.repository.OrderRepository;
import com.wsd.sales.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
    public Double getTotalSaleAmountOfCurrentDay() {
        List<OrderModel> orders = getOrderListOfCurrentDay();

        return orders.stream().mapToDouble(OrderModel::getTotal).sum();
    }

    @Override
    public List<LocalDate> getMaximumSaleDayByTimeRange(String from, String to) throws ParseException {
        Map<LocalDate, Double> totalSalePerDayMap = new HashMap<>();
        LocalDateTime fromDate = formateDate(from);
        LocalDateTime toDate = formateDate(to);
        List<OrderModel> orderModelList = orderRepository.findByOrderAtBetween(fromDate, toDate);

        for (OrderModel orderModel : orderModelList) {
            LocalDate date = orderModel.getOrderAt().toLocalDate();

            totalSalePerDayMap.merge(date, orderModel.getTotal(), Double::sum);
        }
        Double maxValue = Collections.max(totalSalePerDayMap.values());

        List<LocalDate> maxKeys = new ArrayList<>();

        for (var entry : totalSalePerDayMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                maxKeys.add(entry.getKey());
            }
        }

        return maxKeys;
    }

    public LocalDateTime formateDate(String date) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date parsedDate = inputFormat.parse(date);

        return LocalDateTime.parse(outputFormat.format(parsedDate));
    }
}
