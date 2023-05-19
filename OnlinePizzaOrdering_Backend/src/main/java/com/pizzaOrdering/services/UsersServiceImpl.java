package com.pizzaOrdering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzaOrdering.dao.UsersDao;
import com.pizzaOrdering.exception.ResourceNotFoundException;
import com.pizzaOrdering.model.Users;


@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao usersDao;
	
	
	
	//POST => add new user(registration)
	@Override
	public Users addUsers(Users users) {
		return usersDao.save(users);
	}

	//POST  => login
	@Override
	public Users login(String email, String password) {
		return usersDao.findByEmailAndPassword(email, password).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
	}

	//GET => edit/update user credential
	@Override
	public Users editUser(Users users) {
		Users foundUser=usersDao.findById(users.getId()).orElseThrow(()->new RuntimeException("User not found"));
		//when user found
		foundUser.setEmail(users.getEmail());
		foundUser.setPassword(users.getPassword());
		foundUser.setFirst_name(users.getEmail());
		return usersDao.save(foundUser);		
	}
	
	
	//GET => get all users data
	@Override
	public List<Users> getAllUsers() {
	// TODO Auto-generated method stub
	return usersDao.findAll();
}
	
	//GET => user by id
	@Override
	public Users getUsersById(long id) {
		return usersDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found"));
	}


	//DELETE => delete user by id
	@Override
	public Users deleteUsers(long id) {
		usersDao.deleteById(id);
		return null;
	}


}
