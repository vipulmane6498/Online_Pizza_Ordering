package com.pizzaOrdering.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaOrdering.model.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

}
