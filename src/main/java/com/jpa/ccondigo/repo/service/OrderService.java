package com.jpa.ccondigo.repo.service;

import com.jpa.ccondigo.repo.entity.Order;
import com.jpa.ccondigo.repo.entity.OrderItem;
import com.jpa.ccondigo.repo.repository.OrderItemRepository;
import com.jpa.ccondigo.repo.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    // Crear Orden
    @Transactional
    public Order createOrder(Order order) {
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                item.setOrder(order); // ✅ Establecer manualmente la relación
            }
        }
        return orderRepository.save(order);
    }

    // Actualizar Orden
    @Transactional
    public Order updateOrder(Long orderId, Order orderDetails) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setCustomerName(orderDetails.getCustomerName());
        return orderRepository.save(order);
    }

    // Eliminar Orden
    @Transactional
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    // Obtener Orden por ID
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
