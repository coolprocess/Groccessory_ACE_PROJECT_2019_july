package com.niit.groccessory.testcases;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.groccessory.config.DBConfig;
import com.niit.groccessory.dao.CategoryDao;
import com.niit.groccessory.model.Category;

import junit.framework.Assert;

public class CategoryTestcase {

	
	AnnotationConfigApplicationContext context;
	
	Category category;
	CategoryDao categoryDao;
	
	@Before
	public void init()
	{
		context = new  AnnotationConfigApplicationContext(DBConfig.class);
		category = new Category();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void test()
	{
		category.setCname("vegetables");
		category.setCdesc("Fresh Vegetables we will get every day from our farm house");
		Assert.assertEquals("Successfully Record done",categoryDao.addCategory(category));
		
	}
}
