package com.pizzaOrdering.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "reviews")
@Getter
@Setter
@ToString(exclude = {"user_id","pizza_id"})
@Entity
public class Review extends BaseEntity {

	
	//review, rating, user, pizza, postedOn
	@Column(name = "review", length = 1000)
	private String review;
	
	@Column(name = "rating", nullable = false)
	private float rating;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users users;
	
	@ManyToOne
	@JoinColumn(name = "pizza_id", nullable = false)
	private Pizza pizza;
	
	@UpdateTimestamp // hib annotation to update the date auto : @ time of updating cart
	@Column(name = "posted_on")
	private LocalDate postedOn;
	
}
