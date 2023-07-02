package com.pizzaOrdering.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaOrdering.exception.ResourceNotFoundException;
import com.pizzaOrdering.model.Category;
import com.pizzaOrdering.model.Offer;
import com.pizzaOrdering.model.Order;
import com.pizzaOrdering.model.Pizza;
import com.pizzaOrdering.model.Review;
import com.pizzaOrdering.services.CategoryService;
import com.pizzaOrdering.services.OfferService;
import com.pizzaOrdering.services.OrderService;
import com.pizzaOrdering.services.PizzaService;
import com.pizzaOrdering.services.ReviewService;

@CrossOrigin("http://localhost:3000")
@RestController
public class AdminController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	OfferService offerService;
	
	@Autowired
	ReviewService reviewService;
	
	
	@Autowired 
	OrderService orderService;
	
//Category added by admin---------------------------------------------------------------------------------------------------
	
	//add category
	@PostMapping("/addcategory")
	public 	ResponseEntity<Category> addCategory(@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(category));
	}
	
	//edit category
	@PutMapping("/editcategory")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		System.out.println(category);
		return ResponseEntity.status(HttpStatus.OK).body(categoryService.editCategoryByID(category));

	}
	
	
	//get category by id
	@GetMapping("/category/id/{id}")
	public Category getCategoryById(@PathVariable long id){
		System.out.println("in fetch Category of user  " + id);
		return categoryService.findCategoryByID(id).orElseThrow(()-> new ResourceNotFoundException("Category with given id is not found!"));
	}
	
	//get all categories
	@GetMapping("/allcategories")
	public List<Category> seeAllCategory(){
		return categoryService.allCategory();
	}
	
	//delete category by id
	@DeleteMapping("/category/id/{id}")
	public ResponseEntity<String>  deleteCategoryById(@PathVariable long id){
		categoryService.deleteCategoryByID(id);
		return ResponseEntity.noContent().build();	
	}	
//	OR WE CAN DELETE BY BELOW NORMAL WAY************
//	public  void deleteCategoryById(@PathVariable long id) {
//		categoryService.deleteCategoryByID(id);
//	}
	
	
//Pizza =>  handle by admin---------------------------------------------------
	
	//Add Pizza by admin
	@PostMapping("/addpizza")
	public ResponseEntity<Pizza> addPizza(@RequestBody Pizza pizza) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pizzaService.addPizza(pizza));
	}
	
	//edit pizza by admin
	@PutMapping("/editpizza")
	 public ResponseEntity<Pizza> editPizza(@RequestBody Pizza pizza) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pizzaService.updatePizza(pizza));
	}
	
	//delete pizza by admin which admin has added
	@DeleteMapping("/deletepizza/id/{id}")
	public ResponseEntity<String>  removePizzaById(@PathVariable long id) {
		pizzaService.deletePizzaByID(id);
		  return ResponseEntity.noContent().build();
	}
	
//	OR WE CAN DELETE BY BELOW NORMAL WAY************
//	@DeleteMapping("/deletepizza/id/{id}")
//	public void  removePizzaById(@PathVariable long id) {
//		pizzaService.deletePizzaByID(id);
//	}
	
	
	

	
//Offer*******************************************************************
	
	//add Offer
	@PostMapping("/addoffer")
	public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(offerService.addOffer(offer));
	}
	
	//get offer by id
	@GetMapping("/offer/id/{id}")
	public Optional<Offer> getOfferById(@PathVariable long id) {
		return offerService.findOfferById(id);
	}
	
	//get all offers
	@GetMapping("/showalloffers")
	public List<Offer> getAllOffers() {
		return offerService.findAllOffers();
	}
	
	
	//edit offer
	@PutMapping("/editoffer")
	public ResponseEntity<Offer> editOffer(@RequestBody Offer offer) {
		System.out.println(offer);
		return ResponseEntity.status(HttpStatus.OK).body(offerService.updateOffer(offer));
	}
	
	//delete offer
	@DeleteMapping("/deleteoffer/id/{id}")
	public ResponseEntity<String> deleteOfferById(@PathVariable long id) {
		offerService.deleteOfferById(id);
		return ResponseEntity.noContent().build();
	}
//	OR WE CAN DELETE BY BELOW NORMAL WAY************
//	public void deleteOfferById(@PathVariable long id) {
//		offerService.deleteOfferById(id);
//	}
	
//Order*******************************************************************
	
	//show all Orders
	@GetMapping("/orders")
	public List<Order> seeAllOrders() {
		return orderService.findAllOrders();
	}
	
	//edit order=> this is not required once the order has been plcaed order can't be changed 
	@PutMapping("/order/editorder")
	public Order editOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
		
	//Deleting users pizza order=> if order is mistakenly placed
	@DeleteMapping("/order/deleteorder/id/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable long id) {
		orderService.deleteOrderById(id);
		return ResponseEntity.noContent().build();
	}
//	OR WE CAN DELETE BY BELOW NORMAL WAY************
//	public void deleteOrderById(@PathVariable long id) {
//		orderService.deleteOrderById(id);
//	}
	
//Reviews------------------------------------------------------------
	
	//admin can only fetch & delete the reviews
	//user can =>  add reviews & fetch users review by userID & fetch product review by product ID
	
	//get review by id
	@GetMapping("/review/id/{id}")
	public Optional<Review> getReview(@PathVariable long id) {
		return reviewService.getReviewById(id);
	}
	
	//delete review by id
	@DeleteMapping("/deletereview/id/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable long id) {
		 reviewService.deleteReviewById(id);
		 return ResponseEntity.noContent().build();
	}
//	OR WE CAN DELETE BY BELOW NORMAL WAY************
//	public void deleteReview(@PathVariable long id) {
//		 reviewService.deleteReviewById(id);
//	}
	
	//get all reviews
	@GetMapping("/allreviews")
	public List<Review> getAllReviews(){
		return reviewService.findAllReviews();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
