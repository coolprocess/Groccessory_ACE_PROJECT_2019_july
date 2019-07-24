package com.niit.groccessory.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.groccessory.model.Category;

@Component
public interface CategoryDao 
{
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category  getCategory(Integer id);
	public List<Category> retreiveAllCategories();

}

