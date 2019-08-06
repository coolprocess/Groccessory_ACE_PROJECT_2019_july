package com.niit.groccessory.dao;

import org.springframework.stereotype.Component;

import com.niit.groccessory.model.Cart;

@Component
public interface CartDao
{
	
	public boolean addCart(Cart cart);
	public boolean deleteCart(Cart cart);

	public boolean updateCart(Cart cart);
	public Cart getCart(Integer cartId);

}
