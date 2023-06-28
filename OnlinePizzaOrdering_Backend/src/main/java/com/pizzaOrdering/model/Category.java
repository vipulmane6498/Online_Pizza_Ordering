package com.pizzaOrdering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.NegativeOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Category extends BaseEntity{

	@Column(name = "category_name", length = 30, unique = true)  //this name will be automatically add in database
	private String categoryName;  //this name should be add in postman
	
	
	@Column(length = 100)
	private String description;
	
	
	

	}

	
	
	
	
