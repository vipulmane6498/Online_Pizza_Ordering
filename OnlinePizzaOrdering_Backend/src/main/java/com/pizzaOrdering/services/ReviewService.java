package com.pizzaOrdering.services;

import java.util.List;
import java.util.Optional;

import com.pizzaOrdering.model.Review;

public interface ReviewService {

	//add reviews
	public Review addReview(Review review);
	
	//delete review by id
	public void deleteReviewById(long id);
	
	
	//get review by id
	public Optional<Review> getReviewById(long id);
	
	
	//get all reviews
	public List<Review> findAllReviews();
	
	
	
	//find review by USER ID
	public List<Review> findReviewByUsersId(long id);
	
	
	//find review by PIZZA ID
	public List<Review> findReviewByProduct(long id);

}
