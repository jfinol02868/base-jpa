package com.jpa.ccondigo.repo.repository;

import com.jpa.ccondigo.repo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
