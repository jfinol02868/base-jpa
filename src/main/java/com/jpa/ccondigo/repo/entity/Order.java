package com.jpa.ccondigo.repo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
@EqualsAndHashCode(exclude = "orderItems")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @JsonManagedReference // ✅ Evita la recursión infinita
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems;

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
        for (OrderItem item : orderItems) {
            item.setOrder(this); // ✅ Asignación manual
        }
    }
}
