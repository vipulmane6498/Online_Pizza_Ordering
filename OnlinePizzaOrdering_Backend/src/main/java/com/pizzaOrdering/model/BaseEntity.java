package com.pizzaOrdering.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass //Designates a class whose mapping information is appliedto the entities that inherit from it. A mapped superclasshas no separate table defined for it. 

@Setter
@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  		//to generate automatic unique Id
	private Long id;  											//id => common for all implementation
}
