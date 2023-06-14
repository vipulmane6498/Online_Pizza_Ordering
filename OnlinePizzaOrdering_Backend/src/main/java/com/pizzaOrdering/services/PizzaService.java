package com.pizzaOrdering.services;

import java.util.List;
import java.util.Optional;

import com.pizzaOrdering.model.Pizza;

public interface PizzaService {

	
	public Pizza addPizza(Pizza pizza); //add
	
	public void deletePizzaByID(Long Id); //delete
	
	public Pizza updatePizza(Pizza pizza);
	
	public List<Pizza> findAllPizza(); //findPizza
	
	public Optional<Pizza> PizzaByID(Long id);
	
	public List<Pizza> findByCategoryID(long cat_id);
}
