package com.jpa.ccondigo.repo.entity;

import java.io.Serializable;
import java.util.Objects;


public class OrderItemId implements Serializable  {

    private Long order;
    private Long itemId;

    public OrderItemId() {
    }

    public OrderItemId(Long order, Long itemId) {
        this.order = order;
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemId that = (OrderItemId) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, itemId);
    }
}
