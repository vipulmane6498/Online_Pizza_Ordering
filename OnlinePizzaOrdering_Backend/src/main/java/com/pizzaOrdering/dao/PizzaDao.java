package com.pizzaOrdering.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaOrdering.model.Pizza;

public interface PizzaDao extends JpaRepository<Pizza, Long> {

	Optional<List<Pizza>> findByPizzaCategoryId(long cat_id);
	
}
