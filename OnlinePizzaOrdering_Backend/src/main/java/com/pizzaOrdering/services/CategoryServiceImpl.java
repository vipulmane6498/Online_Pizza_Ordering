package com.pizzaOrdering.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaOrdering.model.Category;
import com.pizzaOrdering.dao.CategoryDao;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	//1. add category
//	@Override
	public Category addCategory(Category category) {
		return categoryDao.save(category);
	}
	
	//2. delete category
	@Override
	public void deleteCategoryByID(Long id) {
		categoryDao.deleteById(id);
	}
	
	//2. edit category
	public Category editCategoryByID(Category category) {
		Category updcat = this.categoryDao.findById(category.getId()).orElse(null);
		updcat.setCategoryName(category.getCategoryName());
		updcat.setDescription(category.getDescription());
		return updcat;
	}

	//3. get category by id
	@Override
	public Optional<Category> findCategoryByID(Long id) {
		System.out.println("Finding the category with the Id: "+ id);
		return categoryDao.findById(id);
	}

	
	//4. get all category
	@Override
	public List<Category> allCategory() {
		return categoryDao.findAll();
	}






}
