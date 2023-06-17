package com.pizzaOrdering.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaOrdering.model.ShoppingCart;



public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Long> {

	ShoppingCart findByCartOwnerId(long id);

	
	
}
