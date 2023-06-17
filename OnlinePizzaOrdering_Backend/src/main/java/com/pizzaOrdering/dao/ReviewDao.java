package com.pizzaOrdering.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaOrdering.model.Review;

public interface ReviewDao extends JpaRepository<Review, Long> {


	
	List<Review> findByUsersId(long id);

	List<Review> findByPizzaId(long id);

}
