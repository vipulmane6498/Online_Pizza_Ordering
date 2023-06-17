package com.pizzaOrdering.services;

import java.util.List;
import java.util.Optional;

import com.pizzaOrdering.model.Order;

public interface OrderService {

	
	//add order
	public Order addOrder(Order order);
	
	
	//get order by order id
	public Optional<Order> findOrderById(long id);
	
	
	//get order by userId/cartOwnerId
	public Order findOrderByUserId(long id);
	
	
	//get all orders
	public List<Order> findAllOrders();
	
	
	//delete order by order id
	public void deleteOrderById(long id);
	
	
	//update order
	public Order updateOrder(Order order);
	
	//find order by id
	public Order findByID(Long id);
	

	
}
