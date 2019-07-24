package com.niit.groccessory.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.groccessory.model.Customer;
@Transactional
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao
{

	
	@Autowired
	private SessionFactory sessionfactory;
	
	public boolean addCustomer(Customer customer) {
	
		
		try
		{
			sessionfactory.getCurrentSession().saveOrUpdate(customer);
			return true;
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		return false;
		}
	}

	
	public boolean updateCustomer(Customer customer) {
	
		try
		{
			sessionfactory.getCurrentSession().update(customer);
			return true;
		}
		catch(Exception ae)
		{
		return false;
		}
	}

	
	public Customer getCustomer(Integer id) {
		try
		{
				return sessionfactory.getCurrentSession().get(Customer.class,id);	
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		return null;
		}
	}


	
	public List<Customer> retreiveAllusers() {
	
	
		try {
			return sessionfactory.getCurrentSession().createQuery("from customer",Customer.class).getResultList();
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
			return null;
		}
	}


	
	public Customer getUserDetails(String email) {
		
		try {
			return sessionfactory.getCurrentSession().createQuery("from Customer where email =:email", Customer.class).setParameter("email", email).getSingleResult();
		}
		catch(Exception ae) {
		System.out.println(ae);
			return null;
		}
	}


	
	public boolean deleteCustomer(Customer customer) {
		try {
			sessionfactory.getCurrentSession().remove(customer);
			return true;
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		return false;
		}
	}
	

	

}
