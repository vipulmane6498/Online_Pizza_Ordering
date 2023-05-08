package com.pizzaOrdering.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class Address extends BaseEntity{
	
	
	@Column(length = 10)
	private String house_no;
	
	@Column(length = 50)
	private String street;
	
	@Column(name="city", length = 25)
	@NotBlank(message = "Last name can't be blanck ")
	private String city;
	private String State;
	
	
	private String country;
	
	private String pincode;
	private Users users;

}
