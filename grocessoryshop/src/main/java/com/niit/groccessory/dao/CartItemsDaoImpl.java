package com.niit.groccessory.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.groccessory.model.CartItems;

@Transactional
@Repository("cartitemDao")
public class CartItemsDaoImpl implements CartItemsdao {

	@Autowired
	SessionFactory sf;

	public boolean addCartItems(CartItems cartItems) {

		try {

			sf.getCurrentSession().save(cartItems);

			return true;

		} catch (Exception e) {

			System.out.println(e);

			return false;

		}
	}

	public boolean deletCartItems(CartItems cartItems) {
		try {

			sf.getCurrentSession().remove(cartItems);

			return true;

		} catch (Exception e) {

			return false;

		}
	}

	public boolean updateCartItems(CartItems cartItems) {

		try {

			sf.getCurrentSession().update(cartItems);

			return true;

		} catch (Exception e) {

			return false;

		}
	}

	public CartItems getCartItems(Integer id) {
		try {

			return sf.getCurrentSession().get(CartItems.class, id);

		} catch (Exception e) {

			System.out.println(e);

			return null;

		}
	}

	public ArrayList<CartItems> retreiveAllCartItems() {
		try {

			return (ArrayList<CartItems>) sf.getCurrentSession().createQuery("from CartItems", CartItems.class)
					.getResultList();

		} catch (HibernateException e) {

			e.printStackTrace();

			return null;

		}
	}

	public CartItems getProduct(int productId, int cartId) {
		try {

	return sf.getCurrentSession().createQuery("from CartItems where cart_cartId = :cartId and product_productId= :productId",CartItems.class).setParameter("cartId", cartId).setParameter("productId", productId).getSingleResult();

		} catch (Exception e) {

			System.out.println(e);

			return null;

		}
	}

}
