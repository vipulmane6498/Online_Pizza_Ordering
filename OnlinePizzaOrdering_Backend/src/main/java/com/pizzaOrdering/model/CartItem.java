package com.pizzaOrdering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;


//@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude ="pizza")
@Table(name = "cart_items")
@Entity
public class CartItem extends BaseEntity{

	private int quantity;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	// Cart 1<---* CartItem
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	@JsonIgnore
	private ShoppingCart cart;
	
	// CartItem 1---->1 Product
	@OneToOne
	@JoinColumn(name="pizza_id")
	private Pizza pizza;	
}
