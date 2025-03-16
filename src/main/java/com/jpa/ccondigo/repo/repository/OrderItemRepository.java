package com.jpa.ccondigo.repo.repository;

import com.jpa.ccondigo.repo.entity.OrderItem;
import com.jpa.ccondigo.repo.entity.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}
