package com.niit.groccessory.testcases;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.groccessory.config.DBConfig;
import com.niit.groccessory.dao.CustomerDao;
import com.niit.groccessory.model.Customer;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CustomerTestCase {

	
	AnnotationConfigApplicationContext context;
	
	Customer  customer;
	CustomerDao customerDao;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext(DBConfig.class);
		customer = new Customer();
		customerDao = (CustomerDao) context.getBean("customerDao");
		
	}
	
	/*@SuppressWarnings("deprecation")
	@Test
	public void test()
	{
		
		customer.setFirstName("Chetan");
		customer.setLastName("Sai");
		customer.setMobile("8686469911");
		customer.setEmail("rockandchill2019@gmail.com");
		customer.setAddress("Tarnaka Flat no 406");
		customer.setIs_Active(true);
		customer.setRole("user");
		customer.setPassword("P@ssw0rd1!");
		customer.setConfirmPassword("P@ssw0rd1!");
		
	
		Assert.assertEquals("customer record add successfully", true, customerDao.addCustomer(customer));
	}*/
	
	//updating the customer record
		@Test
		public void test1()
		{
			customer = customerDao.getCustomer(1);
			customer.setAddress("Nallakunta Veg Market Hyd Flat No 406");
			Assert.assertEquals("update successful",true,customerDao.updateCustomer(customer));
		}
}
