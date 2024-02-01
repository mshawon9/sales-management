package com.wsd.sales.repository;

import com.wsd.sales.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    List<OrderModel> findByOrderAtBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
