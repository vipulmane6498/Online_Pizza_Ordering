package com.pizzaOrdering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzaOrdering.model.Order;
import com.pizzaOrdering.model.OrderItem;

@Repository
public interface OrderItemDao extends JpaRepository<OrderItem, Long>{

	Order findByOrderId(long id);

}
