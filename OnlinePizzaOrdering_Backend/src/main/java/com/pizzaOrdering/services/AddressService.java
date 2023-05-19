package com.pizzaOrdering.services;

import java.util.List;
import java.util.Optional;

import com.pizzaOrdering.model.Address;

public interface AddressService {

	Address addAddress(Address address);
	
	void deleteAddressById(long id);
	
	Address editUsersAddress(Address address);
		
	Optional<Address> addressByID(long id);
	
	 List<Address> findAllAddress();

	List<Address> findByUsersId(long id);
	

	List<Address> getAddressByUsers(long id);

}
