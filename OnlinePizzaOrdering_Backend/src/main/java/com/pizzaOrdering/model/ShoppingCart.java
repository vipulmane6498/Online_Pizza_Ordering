package com.pizzaOrdering.model;


//1st ShoppingCart then CartItem
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



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
public class ShoppingCart extends BaseEntity{
	//totalItems,totalCartPrice,createdOn,updatedOn
	
	
	@Column(name = "total_items")
	private int totalItems;
	
	@Column(name = "total_cart_price")
	private double totalCartPrice;
	
	@CreationTimestamp // hib annotation to add creation date auto : once @ time of saving the entity
	@Column(name = "created_on")
	private LocalDate createdOn;
	
	@UpdateTimestamp // hib annotation to update the date auto : @ time of updating cart
	@Column(name = "last_updated_on")
	private LocalDate lastUpdatedOn;
	
	// Cart HAS-A Customer Cart ----> User
	// Cart : one , child , owning
	@OneToOne // def fetch type : EAGER
	@JoinColumn(name = "user_id", nullable = false)
	private Users cartOwner;
}
