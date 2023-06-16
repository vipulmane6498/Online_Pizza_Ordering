package com.pizzaOrdering.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaOrdering.model.Review;

public interface ReviewDao extends JpaRepository<Review, Long> {

}
