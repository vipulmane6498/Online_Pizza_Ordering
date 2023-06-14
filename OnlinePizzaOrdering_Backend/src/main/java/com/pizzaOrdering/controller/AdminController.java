package com.pizzaOrdering.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaOrdering.model.Category;
import com.pizzaOrdering.model.Pizza;
import com.pizzaOrdering.services.CategoryService;
import com.pizzaOrdering.services.PizzaService;


@RestController
//@CrossOrigin("")
public class AdminController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PizzaService pizzaService;
	
//Category added by admin---------------------------------------------------------------------------------------------------
	
	//add category
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category category) {
		this.categoryService.addCategory(category);
		return category;
	}
	
	//edit category
	@PutMapping("/editcategory")
	public Category updateCategory(@RequestBody Category category) {
		System.out.println(category);
		return this.categoryService.editCategoryByID(category);
	}
	
	
	//get category by id
	@GetMapping("/category/id/{id}")
	public Optional<Category> getCategoryById(@PathVariable long id){
		System.out.println("in fetch Category of user  " + id);
		return categoryService.findCategoryByID(id);
	}
	
	//get all categories
	@GetMapping("/categories")
	public List<Category> seeAllCategory(){
		return categoryService.allCategory();
	}
	
	//delete category by id
	@DeleteMapping("/category/id/{id}")
	public  void deleteCategoryById(@PathVariable long id) {
		categoryService.deleteCategoryByID(id);
	}
	
	
//Pizza handle by admin---------------------------------------------------
	
	//Add Pizza by admin
	@PostMapping("/addpizza")
	public Pizza addPizza(@RequestBody Pizza pizza) {
		this.pizzaService.addPizza(pizza);
		return pizza;
	}
	
	//edit pizza by admin
	@PutMapping("/editpizza")
	 public Pizza editPizza(@RequestBody Pizza pizza) {
		return this.pizzaService.updatePizza(pizza);
	}
	
	//delete pizza by admin which admin has added
	@DeleteMapping("/deletepizza/id/{id}")
	public void removePizzaById(@PathVariable long id) {
		pizzaService.deletePizzaByID(id);
	}
	
	
	//*******************************************************************
//	//Deleting users pizza if order is mistakenly placed
//	@DeleteMapping("/pizza/order/deleteorder/id/{id}")
//	public void deleteOrderById(@PathVariable long id) {
//		orderService.deleteorderById(id);
//	}
//	
	
	//*******************************************************************
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
