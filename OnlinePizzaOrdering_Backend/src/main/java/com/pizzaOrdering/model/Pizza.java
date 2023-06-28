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
public class Pizza extends BaseEntity{

	@Column(name = "pizzaName")  //this name automatically saved in database
	private String pizzaName;  //this name should be add in JSON postman 
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "avg_rating", nullable = false)
	private float avg_rating;
	
	@Column (name = "summary")
	private String summary;
	
	@Column (name = "is_veg")
	private boolean isVeg;
	
	@Column (name = "is_NonVeg")
	private boolean isNonVeg;
	
	@Column(name="in_stock")
	private boolean inStock;
	
	
	@ManyToOne()
	@JoinColumn(name="category_id") //to specify FK column name
	private Category pizzaCategory;
	
	@Column(name = "image_path")
	private String imagePath;

	
//	public Pizza(String pizzaName, double price, float avg_rating, String summary, boolean isVeg, boolean inStock) {
//		super();
//		this.pizzaName = pizzaName;
//		this.price = price;
//		this.avg_rating = avg_rating;
//		this.summary = summary;
//		this.isVeg = isVeg;
//		this.inStock = true;
//	}
}

	
	
	
	
