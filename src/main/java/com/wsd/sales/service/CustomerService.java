package com.wsd.sales.service;

import com.wsd.sales.model.CustomerModel;
import com.wsd.sales.model.OrderModel;

import java.util.List;

public interface CustomerService {
    List<CustomerModel> getAllCustomerList();
    List<OrderModel> getAllOrdersByCustomer(long customerId);
}
