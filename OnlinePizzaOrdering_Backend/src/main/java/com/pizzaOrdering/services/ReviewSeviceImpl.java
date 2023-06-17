package com.pizzaOrdering.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzaOrdering.dao.ReviewDao;
import com.pizzaOrdering.model.Review;

@Service
@Transactional
public class ReviewSeviceImpl implements ReviewService {

	@Autowired
	ReviewDao reviewDao;
	
	//add reviews
	@Override
	public Review addReview(Review review) {
		reviewDao.save(review);
		return review;
	}
	
	//delete review by id
	@Override
	public void deleteReviewById(long id) {
		reviewDao.deleteById(id);
	}
	
	//get review by id
	@Override
	public Optional<Review> getReviewById(long id) {
		return reviewDao.findById(id);
	}
	
	//get all reviews
	@Override
	public List<Review> findAllReviews(){
		return reviewDao.findAll();
		}
	
	//find review by USER ID
	public List<Review> findReviewByUsersId(long id) {
		return reviewDao.findByUsersId(id);
	}
	
	//find review by PIZZA ID
	@Override
	public List<Review> findReviewByProduct(long id) {
		return reviewDao.findByPizzaId(id);
	}
	
	
}
