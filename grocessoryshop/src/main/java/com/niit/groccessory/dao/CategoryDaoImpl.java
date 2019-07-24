package com.niit.groccessory.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.groccessory.model.Category;

@Transactional
@Repository("categoryDao")
class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category) {

		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception ae) {
			return false;
		}
	}

	public boolean deleteCategory(Category category) {

		try {
			sessionFactory.getCurrentSession().remove(category);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean updateCategory(Category category) {

		try {

			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ae) {
			ae.printStackTrace();
			return true;
		}
	}

	public Category getCategory(Integer id) {

		try {
			return sessionFactory.getCurrentSession().get(Category.class, id);
		} catch (Exception ae) {
			ae.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public List<Category> retreiveAllCategories() {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).getResultList();
		}
		catch(HibernateException ae)
		{
			ae.printStackTrace();
		return null;
		}
	}
	
	

}
