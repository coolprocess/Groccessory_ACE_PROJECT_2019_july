package com.niit.groccessory.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.groccessory.model.Product;

@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao 
{

	@Autowired
	SessionFactory sessionfactory;
	
	public boolean addProduct(Product product) {
	
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		return false;
		}
	}

	
	public boolean deleteProduct(Product product) {
	
		try {
			sessionfactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception a)
		{
			a.printStackTrace();
		return false;
		}
	}

	
	public boolean updateProduct(Product product) {
	
		try
		{
			sessionfactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		return false;
		}
	}

	@Override
	public Product getProduct(Integer id) {
		
		try

		{

			return sessionfactory.getCurrentSession().get(Product.class, id);

		}

		catch (Exception e)

		{

			return null;

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> retreiveAllProducts() {
		try {

			return sessionfactory.getCurrentSession().createQuery("from Product").getResultList();

			}

			catch (HibernateException e) {

				e.printStackTrace();

				return null;

				

			}

	}

}
