//Address Service Implementation

package com.pizzaOrdering.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaOrdering.dao.AddressDao;
import com.pizzaOrdering.model.Address;



@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao addressDao;
	
	//Adding address-----------------------------------
	public Address addAddress(Address address) {
		addressDao.save(address);
		return address;
	}
	
	
	//find all Addresses--------------------------------
	public List<Address> findAllAddress() {
		return addressDao.findAll();		
	}
	
	//getting address by user id------------------------
	public List<Address> getAddressByUsers(long id) {
		return addressDao.findByUsersId(id);
	}
	
	//getting address by id-----------------------------
	@Override
	public Optional<Address> addressByID(long id) {
		// TODO Auto-generated method stub
		return addressDao.findById(id);
	}

	
	//Deleting Address----------------------------------
	@Override
	public void deleteAddressById(long id) {
		addressDao.deleteById(id);

	}


	@Override
	public List<Address> findByUsersId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public Address editUsersAddress(Address address){
		Address foundUserAddress=addressDao.findById(address.getId()).orElseThrow(()->new RuntimeException("Address not found!!"));
		
		foundUserAddress.setHouse_no(address.getHouse_no());
		foundUserAddress.setStreet(address.getStreet());
		foundUserAddress.setCity(address.getCity());
		foundUserAddress.setState(address.getState());
		foundUserAddress.setCountry(address.getCountry());
		foundUserAddress.setPincode(address.getPincode());
		return addressDao.save(foundUserAddress);
		
	}


}
