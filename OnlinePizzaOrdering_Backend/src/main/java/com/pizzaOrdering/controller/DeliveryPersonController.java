package com.pizzaOrdering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaOrdering.services.AddressService;
import com.pizzaOrdering.services.OfferService;
import com.pizzaOrdering.services.PizzaService;
import com.pizzaOrdering.services.ReviewService;
import com.pizzaOrdering.services.ShoppingCartService;
import com.pizzaOrdering.services.UsersService;

@CrossOrigin("http://localhost:3000")
@RestController
public class DeliveryPersonController {

		
	@Autowired
	UsersService userService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	OfferService offerService;
	
	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	
	
	@GetMapping("/test")
	public void getCartTest() {
		shoppingCartService.addToCart((long)10, (long)4);
	}
	
}
