package com.pizzaOrdering.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pizzaOrdering.dao.PizzaDao;
import com.pizzaOrdering.exception.ResourceNotFoundException;
import com.pizzaOrdering.model.Pizza;

@Service
@Transactional
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	PizzaDao pizzaDao;
	
	//1. add pizza
	@Override
	public Pizza addPizza(Pizza pizza) {
		return pizzaDao.save(pizza);
	}

	//2. delete pizza
	@Override
	public void deletePizzaByID(Long id) {
		System.out.println("Finding the pizza with the Id: "+ id);
		pizzaDao.deleteById(id);
	}
	
	//3. update Pizza
	public Pizza updatePizza(Pizza pizza) {
		Pizza updPiz = this.pizzaDao.findById(pizza.getId()).orElseThrow(()-> new ResourceNotFoundException("pizza Not found"));
		
		updPiz.setPizzaName(pizza.getPizzaName());
		updPiz.setPrice(pizza.getPrice());
		updPiz.setAvg_rating(pizza.getAvg_rating());
		updPiz.setSummary(pizza.getSummary());
		updPiz.setVeg(pizza.isVeg());
		updPiz.setNonVeg(pizza.isNonVeg());
		updPiz.setInStock(pizza.isInStock());
		this.pizzaDao.save(updPiz);
		
		return updPiz;
		
	}

	//4. get pizza by id
	@Override
	public Optional<Pizza> PizzaByID(Long id) {
		System.out.println("Finding the pizza with the Id: "+ id);
		return pizzaDao.findById(id);
	}
	
	//get pizza by id
	@Override
	public Pizza getByID(Long id) {
		return pizzaDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pizza Not found"));
	}
	
	//5. get all pizza
	@Override
	public List<Pizza> findAllPizza() {
		return pizzaDao.findAll();
	}
	
	

	//6. get all pizza
	public List<Pizza> getAll() {
		List<Pizza> allProducts = pizzaDao.findAll();
		return allProducts;
	}
	
	//6. find pizza by category
	public List<Pizza> findByCategoryID(long cat_id){
		return pizzaDao.findByPizzaCategoryId(cat_id).orElseThrow(()-> new ResourceNotFoundException("Pizzas Not found in given category"));
		
	}
	
	
	//7. add pizza by category
	public List<Pizza> getByCategory(Long category_id){
		List<Pizza> items = new ArrayList<>();
		List<Pizza> allItems = new ArrayList<>();

		allItems = pizzaDao.findAll();
		for (Pizza pizza : allItems) {
			if(pizza.getPizzaCategory().getId() == category_id)
			{
				items.add(pizza);
			}
		}
		return items;
	}
	
	
	
	

}
