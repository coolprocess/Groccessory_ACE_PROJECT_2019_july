package com.niit.groccessory.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.groccessory.model.Cart;

@Transactional
@Repository("cartDao")
public class CartDaoImpl implements CartDao 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCart(Cart cart) {
		try {
	
			sessionFactory.getCurrentSession().persist(cart);
	
			return true;
	
	
	
		} catch (Exception e) {
	
			return false;
	
		}
	}
	
	public boolean deleteCart(Cart cart) {
	
	
		try {
	
			sessionFactory.getCurrentSession().remove(cart);
			return true;
		} catch (Exception e) {
	
			return false;
	
		}
	}
	
	public boolean updateCart(Cart cart) {
		try {
	
			sessionFactory.getCurrentSession().update(cart);
			return true;
	
		} catch (Exception e) {
			return false;
		}
	}
	
	public Cart getCart(Integer cartId) {
		try {
	
			return sessionFactory.getCurrentSession().get(Cart.class, cartId);
	
		} catch (Exception e) {
	
			System.out.println(e);
	
			return null;
	
		}
	}
	
	
	
	

}
