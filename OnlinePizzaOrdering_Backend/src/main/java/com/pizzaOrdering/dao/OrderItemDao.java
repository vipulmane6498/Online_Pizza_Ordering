package com.pizzaOrdering.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaOrdering.model.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Long>{

}
