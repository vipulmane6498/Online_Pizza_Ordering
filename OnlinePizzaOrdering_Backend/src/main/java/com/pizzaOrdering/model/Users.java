package com.pizzaOrdering.model;

//import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name="users")
@Entity
public class Users extends BaseEntity{
	
	//@Length (min=4,max=20,message="Invalid or Blank first Name!!")
	@Column(name="first_name", length = 50)
	private String first_name;
	
	@Column(name="last_name", length = 50)
	private String last_name;
	
	@Column(length = 50, unique=true)
	private String email;
	
	@Column(nullable = false)  //password should not be null
	//@Length(min = 5, max= 50)
	private String password;
	
	@Column(length=10, unique=true)  //mobile number should be unique
	private  String mobile_no;
	
	@Enumerated(EnumType.STRING)  //our users role is in  ==> CUSTOMER, DELIVERYPARTNER, ADMIN, MANAGER which are in ENUMTYPE  
	@Column(name="user_role", length = 30)
	private Role userRole;






}
