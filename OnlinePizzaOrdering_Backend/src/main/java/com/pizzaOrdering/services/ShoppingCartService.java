package com.pizzaOrdering.services;

import java.util.List;

import com.pizzaOrdering.model.CartItem;
import com.pizzaOrdering.model.Order;
import com.pizzaOrdering.model.ShoppingCart;
import com.pizzaOrdering.model.Users;

public interface ShoppingCartService {

//ShoppingCart-----------------------------------------------------

	//addCartToUser => when user create an account single Cart will be automatically added to his account then he can do CRUD ops.
	public ShoppingCart addCartToUser(Users users);
	
	//add to cart
	public ShoppingCart addToCart(long user_id, long pizza_id);
	
	//update cart
	public ShoppingCart updateCart(ShoppingCart cart);
	
	//delete from cart
	public ShoppingCart removeFromCart(long user_id,long pizza_id);
	
	//get cart by user_id
	public ShoppingCart getCartByUserID(long user_id) ;
	
	//checkout for payment
	public Order checkout(long user_id, long address_id,String paymentType, 
			double discount, double deliveryPrice, double taxAmount);
	
//Cart Item--------------------------------------------------------------------------------

		//delete cartItem
	public void deleteCartItemByID(long id);
		
	public List<CartItem> getCartItemByCartId(long cart_id);
	
	
}
