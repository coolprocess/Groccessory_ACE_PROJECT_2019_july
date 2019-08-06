package com.niit.groccessory.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.niit.groccessory.model.CartItems;

@Component
public interface CartItemsdao {

	
	boolean addCartItems(CartItems cartItems);

	boolean deletCartItems(CartItems cartItems);

	boolean updateCartItems(CartItems cartItems);

	CartItems getCartItems(Integer id);

	ArrayList<CartItems> retreiveAllCartItems();

	CartItems getProduct(int productId, int cartId);
}
