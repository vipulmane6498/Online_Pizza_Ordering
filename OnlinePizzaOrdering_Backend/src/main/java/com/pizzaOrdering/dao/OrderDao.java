package com.pizzaOrdering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzaOrdering.model.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Long>{

	Order findByCartOwnerId(long id);

}
