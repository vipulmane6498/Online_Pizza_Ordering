package com.pizzaOrdering.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzaOrdering.model.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Long>{

	Optional<Users> findByEmailAndPassword(String email, String password);
	
	
	
	
}
