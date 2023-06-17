package com.pizzaOrdering.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "offers")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Offer extends BaseEntity {

private String name;
	
	private int discount;
	
	private Date valid_from;
	
	private Date valid_upto;
	
	
	@Column(length = 50, unique = true)
	private String code;
	
	@Column(length = 1000)
	private String terms_conditions;
}
