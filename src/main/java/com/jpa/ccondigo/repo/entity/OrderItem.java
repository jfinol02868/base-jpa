package com.jpa.ccondigo.repo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderItemId.class)
@Entity(name = "orderItems")
@EqualsAndHashCode(exclude = "order")
public class OrderItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @MapsId("order")
    @JsonBackReference // ✅ Evita la recursión infinita
    private Order order;

    @Id
    private Long itemId;
    private String productName;
    private int quantity;
}
