package com.pizzaOrdering.services;

import java.util.List;
import java.util.Optional;

import com.pizzaOrdering.model.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	
	public Category editCategoryByID(Category category);
	
	void deleteCategoryByID(Long id);
	
	public  Optional<Category> findCategoryByID(Long id);
	
	public List<Category> allCategory();


}
