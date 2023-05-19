package com.pizzaOrdering.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.pizzaOrdering.model.Address;
import com.pizzaOrdering.model.Users;
import com.pizzaOrdering.services.AddressService;
import com.pizzaOrdering.services.UsersService;

@RestController
public class UserController {
	
	
	@Autowired 
	UsersService usersService;
	
	@Autowired
	AddressService addressService;
	
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
	
	//delete/remove user from DB
	@DeleteMapping("/removeuser/id/{id}")
	Users removeUser(@PathVariable long id) {
		return usersService.deleteUsers(id);
	}
	
	
	//Address------------------------------------------------------
	@PostMapping("/address")
	public Address addAddress(@RequestBody Address address) {
		this.addressService.addAddress(address);
		return address;
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
	public void deleteAddressUserByID(@PathVariable long id) {
		addressService.deleteAddressById(id);
	}
	
	//update/edit user address 
	@PutMapping("/editusersaddress/id/{id}")
	Address updateUserAddress(@RequestBody Address address) {
		return addressService.editUsersAddress(address);
	}
	
	
	
	
	

}
