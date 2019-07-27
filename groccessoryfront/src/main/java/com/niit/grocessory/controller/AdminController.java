package com.niit.grocessory.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.groccessory.dao.CategoryDao;
import com.niit.groccessory.dao.ProductDao;
import com.niit.groccessory.model.Category;
import com.niit.groccessory.model.Product;

@Controller
@RequestMapping("/admin")
public class AdminController 
{

	@Autowired
	CategoryDao categoryDao;
	
	Category category;
	
	@Autowired
	ProductDao productDao;
	
	Product product;
	
	@RequestMapping("/category")
	public ModelAndView categorylist(Model m) {

		Category category = new Category();
		m.addAttribute(category);

		List<Category> listcat = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcat);;
		
		return new ModelAndView("category");

	}  
	
	
	@SuppressWarnings("unused")
	@RequestMapping(value= "/catprocess", method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category , Model m)
	{
		System.out.println("cat id =" + category.getCid());
		
		 if (category.getCid() != 0) {
		 
		 categoryDao.updateCategory(category);
		 
		 }
		 else
		
		categoryDao.addCategory(category);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		return "redirect:/admin/category";
	}
	
	@RequestMapping(value= "updateCat/{cid}")
	public String updateCategory(@PathVariable("cid") int cid , Model m)
	{
		category = categoryDao.getCategory(cid);
		m.addAttribute("category",category);
		System.out.println("it is in update category "+category.getCid());
		categoryDao.updateCategory(category);
		m.addAttribute(category);
		System.out.println("after process "+category.getCid());
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist",listcategories);
		return "category";
		
	}
	
	@RequestMapping(value = "deleteCat/{cid}")
	public String deleteCategory(@PathVariable("cid") int cid, Model m) {
		
		Category c = categoryDao.getCategory(cid);		
		categoryDao.deleteCategory(c);

		Category category = new Category();

		m.addAttribute(category);

		List<Category> listcategories = categoryDao.retreiveAllCategories();

		m.addAttribute("catlist", listcategories);

		return "redirect:/admin/category";

		
	}
		
	//Product Details 
	@RequestMapping(value="/prodProcess", method= RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, @RequestParam("pimage") MultipartFile mfile, Model m, BindingResult result, HttpServletRequest request) 
	{
		
		productDao.addProduct(product);
		String path = request.getServletContext().getRealPath("/resources/");

		String totalFilewithPath = path + String.valueOf(product.getProductId()) + ".jpg";

		File productImage = new File(totalFilewithPath);

		if (!mfile.isEmpty()) 
		{

			try {

				byte fileBuffer[] = mfile.getBytes();

				FileOutputStream fos = new FileOutputStream(productImage);

				BufferedOutputStream bs = new BufferedOutputStream(fos);

				bs.write(fileBuffer);

				bs.close();

			} catch (Exception e) {

				m.addAttribute("File Exception", e);

		}
			
		}
		
		else {

				m.addAttribute("error", "problem in uploading image");

			}

			List<Product> listProducts = productDao.retreiveAllProducts();

			m.addAttribute("prodlist", listProducts);

			List<Category> listcategories = categoryDao.retreiveAllCategories();

			m.addAttribute("catlist", listcategories);

			return "redirect:/admin/productp";


		
		
	}
}