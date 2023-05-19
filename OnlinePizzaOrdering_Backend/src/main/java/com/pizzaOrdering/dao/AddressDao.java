package com.pizzaOrdering.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaOrdering.model.Address;


public interface AddressDao extends JpaRepository<Address, Long>{

	List<Address> findAllByUsersId(long id);

	List<Address> findByUsersId(long id);


}
