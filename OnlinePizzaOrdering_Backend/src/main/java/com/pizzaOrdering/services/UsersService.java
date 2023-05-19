package com.pizzaOrdering.services;

import java.util.List;

import com.pizzaOrdering.model.Users;


public interface UsersService{

	//POST
	Users addUsers(Users users);
	
	
	//POST
	Users login(String email, String password);
	
	
	//PUT
	Users editUser(Users users);
	
	//GET
	Users getUsersById(long id);
	
	//GET
	List<Users> getAllUsers();
	
	
	//DELETE
	Users deleteUsers(long id);


//	Users deleteUsers();	
}
