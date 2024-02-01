package com.wsd.sales.repository;

import com.wsd.sales.model.OrderLineModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLineModel, Long> {
}
