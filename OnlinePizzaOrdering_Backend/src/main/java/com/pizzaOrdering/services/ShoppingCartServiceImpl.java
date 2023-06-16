package com.pizzaOrdering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzaOrdering.dao.AddressDao;
import com.pizzaOrdering.dao.CartItemDao;
import com.pizzaOrdering.dao.OrderDao;
import com.pizzaOrdering.dao.OrderItemDao;
import com.pizzaOrdering.dao.ShoppingCartDao;
import com.pizzaOrdering.exception.ResourceNotFoundException;
import com.pizzaOrdering.model.Address;
import com.pizzaOrdering.model.CartItem;
import com.pizzaOrdering.model.Order;
import com.pizzaOrdering.model.Pizza;
import com.pizzaOrdering.model.ShoppingCart;
import com.pizzaOrdering.model.Users;
import com.pizzaOrdering.model.DeliveryStatus;
import com.pizzaOrdering.model.OrderItem;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	ShoppingCartDao shoppingCartDao;
	
	@Autowired
	PizzaService pizzaService;
//	PizzaServiceImpl pizzaServiceImpl;
	
	
	@Autowired
	UsersServiceImpl usersServiceImpl;
	
	@Autowired
	CartItemDao cartItemDao;
	
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderItemDao orderItemDao;
	
	@Autowired
	AddressDao addressDao;

//Cart(addCartToUser, addToCart, udateCart, removeFromCart,DeleteCart, getCartByUserID)--------------------------------------------------------------
	
	
	//addCartToUser => when user create an account single Cart will be automatically added to his account then he can do CRUD ops.
	public ShoppingCart addCartToUser(Users users) {
		ShoppingCart cart=new ShoppingCart();
		cart.setCartOwner(users);
		shoppingCartDao.save(cart);
		return cart;
	}
	
	//add to cart
	public ShoppingCart addToCart(long user_id, long pizza_id) {
		//get/select pizza by id
		Pizza pizza=pizzaService.getByID(pizza_id);
		System.out.println("Got Pizza: "+pizza);
		
		//Get Cart by owner id
		ShoppingCart cart=shoppingCartDao.findByCartOwnerId(user_id);
		System.out.println("Got cart: "+cart);
		
		//get pizza by id & cart by id
		CartItem cartItem=cartItemDao.findByPizzaIdAndCartId(pizza_id, cart.getId());
		System.out.println("GotCartItem: "+cartItem);
		
		if(cartItem == null) {
			cartItem=new CartItem();
			cartItem.setPizza(pizza);
			cartItem.setCart(cart);
			System.out.println("New cartItem created: "+cartItem);
			cartItemDao.save(cartItem);
		}
		
		int newQuantity =  cartItem.getQuantity();
		newQuantity++;
		System.out.println("Quantity: "+newQuantity);
		System.out.println("Pizza Price: "+pizza.getPrice());
		double newPrice = (newQuantity * pizza.getPrice());
		System.out.println("Total Price: "+newPrice);
		cartItem.setTotalPrice(newPrice);
		cartItem.setQuantity(newQuantity);
		System.out.println("new cartItem is ready" +cartItem);
		System.out.println("new cartItem is saved" +cartItem);

		System.out.println("new cart saved: "+shoppingCartDao.save(cart));
		
		ShoppingCart updatedCart = this.updateCart(cart);
		
		return shoppingCartDao.save(cart);
		
	}

	
	//update cart
	public ShoppingCart updateCart(ShoppingCart cart) {
		List<CartItem> cartItems=cartItemDao.findByCartId(cart.getId());
		Double cartPrice=0.0;
		int count = 0;
		for (CartItem item : cartItems) {
			cartPrice += item.getTotalPrice();
			count++;
        }
		cart.setTotalCartPrice(cartPrice);
		cart.setTotalItems(count);
		
		return cart;
	}
	
	//delete from cart
	public ShoppingCart removeFromCart(long user_id,long pizza_id) {
		
		//1st get the pizza by id
		Pizza pizza=pizzaService.getByID(pizza_id);
		System.out.println("Got pizza: "+pizza);
		
		//2nd get cartOwnerId
		ShoppingCart cart=shoppingCartDao.findByCartOwnerId(user_id);
		System.out.println("Got pizza: "+cart);
		
		//3rd get pizza by id & cart by id
		CartItem cartItem=cartItemDao.findByPizzaIdAndCartId(pizza_id, cart.getId());
		System.out.println("GotCartItem: "+cartItem);
		
		if(cartItem == null) {
			System.out.println("Quantity is zero");
			return cart;
		}
		
		int newQuantity = cartItem.getQuantity();
		
		if(newQuantity == 1) {
			System.out.println("Quantity is Zero!");
			cartItemDao.delete(cartItem);
			ShoppingCart updatedCart = this.updateCart(cart);
			System.out.println("Updated cart: "+updatedCart);
			return shoppingCartDao.save(updatedCart);
		}
		else if(newQuantity <= 0) {
			throw new ResourceNotFoundException("Quantity less than zero");
		}
		else{
			newQuantity--;
			} 
		
		System.out.println("Quantity: "+newQuantity);
		System.out.println("Pizza Price: "+pizza.getPrice());
		double newPrice = (newQuantity * pizza.getPrice());
		System.out.println("Total Price: "+newPrice);
		cartItem.setTotalPrice(newPrice);
		cartItem.setQuantity(newQuantity);
		
		System.out.println("new cartItem is ready" +cartItem);
		cartItemDao.save(cartItem);
		
		System.out.println("new cartItem is saved" +cartItem);
		System.out.println("new cart saved: "+shoppingCartDao.save(cart));
		
		ShoppingCart updatedCart = this.updateCart(cart);
		return shoppingCartDao.save(updatedCart);
		
	}
	
	//get cart by user_id
	public ShoppingCart getCartByUserID(long user_id) {
		return shoppingCartDao.findByCartOwnerId(user_id);
	}
	
	//checkout for payment
	public Order checkout(long user_id, long address_id,String paymentType, 
			double discount, double deliveryPrice, double taxAmount) {
		
		/* Step 1. Get list of cart items
		 * step 2. create new order
		 * step 3. create new order item for each order - in loop
		 * step 4. copy each cart item to order items - in loop
		 * Step 5. delete cart item - in loop
		 * step 5. copy additional info (total price etc) to orders
		 * step 6. update the cart (total price, count etc)
		 * step 7. save updated cart to DB
		 * step 8. save & return order
		 */
		
		
		Users users=usersServiceImpl.getUsersById(user_id); //get user by id
		Address address=addressDao.findById(address_id).orElse(null); //get address id
		
		
		Order order=new Order();
		ShoppingCart cart=shoppingCartDao.findByCartOwnerId(users.getId()); //get cart owner id
		List<CartItem> cartItems = cartItemDao.findByCartId(cart.getId()); //get cartItem by id
		System.out.println("cartItems in order "+cartItems);
		
		if (cartItems.isEmpty()) {
			System.out.println("order cannot be placed with empty cart");
			return null;
		}
		
		System.out.println("Before loop");
		System.out.println("Got cart items: "+cartItems);
		for (CartItem cartItem : cartItems) {
			com.pizzaOrdering.model.OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setPizza(cartItem.getPizza());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setTotalPrice(cartItem.getTotalPrice());
			order.getOrderItems().add(orderItem);
			System.out.println("Order Item Saved");
			cartItemDao.delete(cartItem);
        }
		
		System.out.println("After loop" +cart);
		
		order.setCartOwner(cart.getCartOwner());
		order.setTotalItems(cart.getTotalItems());
		order.setCartPrice(cart.getTotalCartPrice());
		
		order.setStatus(DeliveryStatus.PLACED);
		order.setAddress(address);
		order.setDiscount(discount);
		order.setDeliveryPrice(deliveryPrice);
		order.setPaymentType(paymentType);
		order.setTaxAmount(taxAmount);
		
		order.setTotalOrderPrice(cart.getTotalCartPrice()+deliveryPrice+taxAmount-discount);
		ShoppingCart updatedCart = this.updateCart(cart);
		shoppingCartDao.save(updatedCart);
		
		return orderDao.save(order);
		
	}
	

//Cart Item--------------------------------------------------------------------------------

	//delete cartItem
	public void deleteCartItemByID(long id) {
		CartItem item= cartItemDao.findById(id).orElse(null);
		ShoppingCart cart=item.getCart();
		cartItemDao.deleteById(id);
		this.updateCart(cart);
		
		}
	
	public List<CartItem> getCartItemByCartId(long cart_id) {
		return cartItemDao.findByCartId(cart_id); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
