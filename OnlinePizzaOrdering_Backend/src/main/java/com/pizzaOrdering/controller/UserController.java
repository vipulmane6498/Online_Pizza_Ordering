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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pizzaOrdering.dao.OrderItemDao;
import com.pizzaOrdering.exception.ResourceNotFoundException;
import com.pizzaOrdering.model.Address;
import com.pizzaOrdering.model.CartItem;
import com.pizzaOrdering.model.Order;
import com.pizzaOrdering.model.OrderItem;
import com.pizzaOrdering.model.Pizza;
import com.pizzaOrdering.model.Review;
import com.pizzaOrdering.model.ShoppingCart;
import com.pizzaOrdering.model.Users;
import com.pizzaOrdering.services.AddressService;
import com.pizzaOrdering.services.CategoryService;
import com.pizzaOrdering.services.OrderService;
import com.pizzaOrdering.services.PizzaService;
import com.pizzaOrdering.services.ReviewService;
import com.pizzaOrdering.services.ShoppingCartService;
import com.pizzaOrdering.services.UsersService;

@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {
	
	
	@Autowired 
	UsersService usersService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemDao orderItemDao;
	
//user registration => he can be admin, customer, delivery partner
	
	//user registration ==> that can be customer, admin,deliveryBoy-----------------------------------------------------
	@PostMapping("/register")  //go to postman and post new user data in JSON format to register
	public ResponseEntity<Users> register(@RequestBody Users users) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.addUsers(users));
	}
	
	
	//user login ==> that can be customer, admin,deliveryPartner------------------------------------------------------------
	@GetMapping("/login")
	ResponseEntity<Users> loginCustomer(@RequestParam String email, @RequestParam String password) {
		Users users1 = this.usersService.login(email, password);
		return ResponseEntity.status(HttpStatus.OK).body(users1);
	}
	
	//fetch user by id
	@GetMapping("/getallusers")
	public List<Users> getAllUsers(){
		return usersService.getAllUsers();
	}
	
	@GetMapping("/user/id/{id}")
	public Users getUserById(@PathVariable long id) {
		return usersService.getUsersById(id);
	}
	
	//update/edit user credential 
	@PutMapping("/edituserscreds")
	ResponseEntity<Users> updateUser(@RequestBody Users users) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usersService.editUser(users));
	}
	
	//delete/remove user from DB
	@DeleteMapping("/removeuser/id/{id}")
	Users removeUser(@PathVariable long id) {
		return usersService.deleteUsers(id);
	}

	
	
//Address => user------------------------------------------------------
	
	@PostMapping("/addaddress")
	public  ResponseEntity<Address> addAddress(@RequestBody Address address) {
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.addAddress(address));
	}




	@GetMapping("/addresses")
	public List<Address> seeAllAddress(){
		return this.addressService.findAllAddress();
	}
	
	@GetMapping("/addressbyuser/id/{id}")
	public List<Address> getAddressByUser(@PathVariable long id){
		return this.addressService.getAddressByUsers(id);
	}
	
	@DeleteMapping("/address/id/{id}")
	public ResponseEntity<String> deleteAddressByID(@PathVariable long id) {
		addressService.deleteAddressById(id);
		return ResponseEntity.noContent().build();
	}
//	OR WE CAN DELETE BY BELOW NORMAL WAY************
//	public void deleteAddressUserByID(@PathVariable long id) {
//		addressService.deleteAddressById(id);
//	}
	
	//update/edit user address 
	@PutMapping("/editusersaddress/id/{id}")
	ResponseEntity<Address> updateUserAddress(@RequestBody Address address) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(addressService.editUsersAddress(address));
	}
	
	
//Pizza Home Page or handle by customer------------------------------------------------------
	
	//show all pizza on home page
	@GetMapping("/pizzas")
	public List<Pizza> getAllPizza(){
		return this.pizzaService.findAllPizza();
		}
	
	//show pizzas by category
	@GetMapping("/pizzabycat/id/{id}")
	public List<Pizza> getPizzaByCatId(@PathVariable long id){
		return pizzaService.findByCategoryID(id);
	}
	
	@GetMapping("/pizza/id/{id}")
	public Pizza getPizzaById(@PathVariable long id) {
		return pizzaService.PizzaByID(id).orElseThrow(()-> new ResourceNotFoundException("Invalid id, Please enter valid id."));
	}
	

//ShoppingCart------------------------------------------------------------------
	
	//add to cart
	@PostMapping("/addtocart")
	public ResponseEntity<ShoppingCart> addToCart(@RequestParam("userId") long userId, @RequestParam("pizzaId") long pizzaId) {
		return ResponseEntity.status(HttpStatus.CREATED).body(shoppingCartService.addToCart(userId, pizzaId));
	}
	
	//remove Item from cart
	@DeleteMapping("/removefromcart")
	public ShoppingCart removeFromCart(@RequestParam("userId") long userId, @RequestParam("pizzaId") long pizzaId) {
		return shoppingCartService.removeFromCart(userId, pizzaId);
	}
	
	
	//checkout
	@PostMapping("/checkout")
	public Order checkout(@RequestBody Order order) {
		return shoppingCartService.checkout(order.getCartOwner().getId(),order.getAddress().getId(), order.getPaymentType(),order.getDiscount(),order.getDeliveryPrice(), order.getTaxAmount());
	}
	
	//getCartByUserId
	@GetMapping("/carts/user-id/{user_id}")
	public ShoppingCart getCartByUserId(@PathVariable long user_id) {
		return shoppingCartService.getCartByUserID(user_id);
	}
	
	//CartItems--------------------------------------------
	
	//getCartItemsByCartId
	@GetMapping("/cartitems/cartId/{cart_id}")
	public List<CartItem> getCartItemsByCartId(@PathVariable long cart_id) {
		return shoppingCartService.getCartItemByCartId(cart_id);
	}
	
	@DeleteMapping("/deletecartitem/id/{id}")
	public ResponseEntity<String> deleteCartItemById(@PathVariable long id) {
		shoppingCartService.deleteCartItemByID(id);
		return ResponseEntity.noContent().build();
	}
//OR WE CAN DELETE BY BELOW NORMAL WAY************
//	public void deleteCartItemById(@PathVariable long id) {
//		shoppingCartService.deleteCartItemByID(id);
//	}
	
	
//Review------------------------------------------------------------
//Order & Review => once you place the order then you are applicable to provide a Review--------------------------------------------------------
	
	
//Order ------
	
	//add order
	@PostMapping("/placeorder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder(order));
	}
	
	//get order by orderID
	@GetMapping("/order/id/{id}")
	public Optional<Order> getOrderById(@PathVariable long id) {
		return orderService.findOrderById(id);
	}
	
	//get order by userID
	@GetMapping("/orderbyuser/id/{id}")
	public Order getorderByUserId(@PathVariable long id) {
		return orderService.findOrderByUserId(id);
	}
	
	//find orderItem by orderID
	@GetMapping("/orderitembyorder/id/{id}")
	public Order findOrderItemsByOrder(@PathVariable long id) {
		return orderItemDao.findByOrderId(id);
	}
	
	
	
//Reviews----
	
	//admin can only fetch & delete the reviews
	//user can =>  add reviews & fetch users review by userID & fetch product review by product ID

	//add review
	@PostMapping("/addreview")
	public ResponseEntity<Review> addReview(@RequestBody Review review) {
		return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.addReview(review));
	}
	
	//get user review by user id
	@GetMapping("/userreviews/id/{id}")
	public List<Review> getUserReviews(@PathVariable long id) {
		return reviewService.findReviewByUsersId(id);
	}
	
	//get product review by product id
	@GetMapping("/productreview/id/{id}")
	public List<Review> getProductReviews(@PathVariable long id){
		return reviewService.findReviewByProduct(id);
	}

	
}
