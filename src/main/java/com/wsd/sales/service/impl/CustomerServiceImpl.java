package com.wsd.sales.service.impl;

import com.wsd.sales.model.CustomerModel;
import com.wsd.sales.model.OrderModel;
import com.wsd.sales.repository.CustomerRepository;
import com.wsd.sales.repository.OrderRepository;
import com.wsd.sales.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<CustomerModel> getAllCustomerList() {
        LOGGER.info("fetching customer list from DB");
        return customerRepository.findAll();
    }

    @Override
    public List<OrderModel> getAllOrdersByCustomer(long customerId) {
        LOGGER.info("fetching orders by customer id - " + customerId);
        return orderRepository.findAllByCustomerId(customerId);
    }
}
