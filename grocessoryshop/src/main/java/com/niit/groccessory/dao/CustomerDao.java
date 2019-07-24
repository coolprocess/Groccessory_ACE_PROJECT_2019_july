package com.niit.groccessory.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.groccessory.model.Customer;

@Component
public interface CustomerDao {

	
	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public  Customer getCustomer(Integer id);
	public List<Customer> retreiveAllusers() ;
	public Customer getUserDetails(String email);
	public boolean deleteCustomer(Customer customer);
}
