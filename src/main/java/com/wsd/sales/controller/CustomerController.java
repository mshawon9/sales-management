package com.wsd.sales.controller;

import com.wsd.sales.model.CustomerModel;
import com.wsd.sales.model.OrderModel;
import com.wsd.sales.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/list")
    public List<CustomerModel> getCustomerList() {

        return customerService.getAllCustomerList();
    }

    @GetMapping("/{customerId}/orders")
    public ResponseEntity<List<OrderModel>> getCustomerOrders(@PathVariable long customerId) {

        return new ResponseEntity<>(customerService.getAllOrdersByCustomer(customerId), HttpStatus.OK);
    }


}
