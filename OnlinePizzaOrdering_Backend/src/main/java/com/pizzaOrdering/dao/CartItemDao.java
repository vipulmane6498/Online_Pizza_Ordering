package com.pizzaOrdering.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaOrdering.model.CartItem;

public interface CartItemDao extends JpaRepository<CartItem, Long> {

	CartItem findByPizzaIdAndCartId(long pizza_id, Long id);

	List<CartItem> findByCartId(Long id);

}
