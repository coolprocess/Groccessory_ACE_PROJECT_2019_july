package com.niit.groccessory.testcases;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.groccessory.config.DBConfig;
import com.niit.groccessory.dao.CategoryDao;
import com.niit.groccessory.dao.ProductDao;
import com.niit.groccessory.model.Category;
import com.niit.groccessory.model.Product;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ProductTestCase 
{
	
	AnnotationConfigApplicationContext context;
	Product product;
	Category category;
	
	ProductDao productDao;
	CategoryDao categoryDao;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext(DBConfig.class);
		productDao = (ProductDao) context.getBean("productDao");
		product = new Product();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
		category = new Category();
		
		

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test()
	{
		category.setCname("Rice Brands");
		category.setCdesc("all category of rice you will get here");
		product.setProductName("sonnamassori");
		product.setProductDesc("karnool sona masoori is brand");
		product.setProductPrice(1250);
		product.setStock(4000);
		product.setCategory(category);
		Assert.assertEquals("Category added successfully", true, categoryDao.addCategory(category) );

		Assert.assertEquals("Product added successfully", true, productDao.addProduct(product));		
	}


}
