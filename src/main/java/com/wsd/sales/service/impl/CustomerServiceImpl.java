package com.wsd.sales.service.impl;

import com.wsd.sales.model.CustomerModel;
import com.wsd.sales.repository.CustomerRepository;
import com.wsd.sales.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public List<CustomerModel> getAllCustomerList() {
        return customerRepository.findAll();
    }
}
