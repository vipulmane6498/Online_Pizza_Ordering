package com.pizzaOrdering.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaOrdering.model.Users;
import com.pizzaOrdering.services.UsersService;

@RestController
public class UserController {
	
	
	@Autowired 
	UsersService usersService;
	
	
	//user registration ==> that can be customer, admin,deliveryBoy-----------------------------------------------------
	@PostMapping("/register")  //go to postman and post new user data in JSON format to register
	public Users register(@RequestBody Users users) {
		return usersService.addUsers(users);
	}
	
	
	//user login ==> that can be customer, admin,deliveryboy------------------------------------------------------------
	@PostMapping("/login")
	ResponseEntity<Users> loginCustomer(@RequestParam String email, @RequestParam String password) {
		Users users1 = this.usersService.login(email, password);
		return ResponseEntity.status(HttpStatus.OK).body(users1);
	}
	
	//fetch user by id
	@GetMapping("/getallusers")
	public List<Users> getAllUsers(){
		return usersService.getAllUsers();
	}
	
	//update/edit user credential 
	@PutMapping("/edituserscreds")
	Users updateUser(@RequestBody Users users) {
		return usersService.editUser(users);
	}
	

}
