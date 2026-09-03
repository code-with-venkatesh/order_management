package org.example.order_management.infrastructure.rdb.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.example.order_management.domain.entity.Order;
import org.example.order_management.domain.enums.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(OrderStatus status);
}