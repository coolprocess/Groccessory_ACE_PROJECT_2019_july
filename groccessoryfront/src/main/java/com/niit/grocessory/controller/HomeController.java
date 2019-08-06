package com.niit.grocessory.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.groccessory.dao.CartDao;
import com.niit.groccessory.dao.CategoryDao;
import com.niit.groccessory.dao.CustomerDao;
import com.niit.groccessory.dao.ProductDao;
import com.niit.groccessory.model.Cart;
import com.niit.groccessory.model.Category;
import com.niit.groccessory.model.Customer;
import com.niit.groccessory.model.Product;

@Controller
public class HomeController {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	CartDao cartDao;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView Home(Model mm , Principal p)
	{

		if(p!=null)
		{
			Customer customer = customerDao.getUserDetails(p.getName());
			if(!customer.getRole().equals("ROLE_ADMIN"))
			{
				Cart cart = customer.getCart();
				mm.addAttribute("cart",cart);
				mm.addAttribute("customer",customer);
				return new ModelAndView("userpage");
			}
			else {
				return new ModelAndView("Adminpage");		
			}
		}
		return new ModelAndView("index");
		

	}

	@RequestMapping("/reg")
	public ModelAndView registerPage(Model m) {
		Customer customer = new Customer();

		m.addAttribute("customer", customer);
		return new ModelAndView("signup");
	}

	@RequestMapping("/signupProcess")
	public String signupPage(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,Model m)
	{
		
		if(result.hasErrors())
		{
			m.addAttribute("customer",customer);
			return "signup";
		}
		else
		{
			
			if(!(customer.getPassword().equals(customer.getConfirmPassword())))
					{
				m.addAttribute(customer);
				m.addAttribute("errorpass","passowrd should match");
				return "signup";
					}
			else
			{
				Cart cart = new Cart();
				customer.setCart(cart);
				cart.setCustomer(customer);
				
				customerDao.addCustomer(customer);
				cartDao.addCart(cart);
				List<Category> listcategories = categoryDao.retreiveAllCategories();
				m.addAttribute("catlist", listcategories);
				return "redirect:/";
			}
		}
	}
	
	@RequestMapping("/login")
	public String loginpage(Model m)
	{
		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);

		
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		
		return "login";
	}
	
	@RequestMapping("/products")
	public ModelAndView product(Model m , Principal p)
	{
		if(p!=null)
		{
			Customer customer = customerDao.getUserDetails(p.getName());
			Cart cart = customer.getCart();
			m.addAttribute("cart",cart);
			m.addAttribute(customer);
		}
		
		
		Product prod = new Product();
		m.addAttribute(prod);
		
		List<Product> listproducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listproducts);
		List<Category> listcategories= categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return new ModelAndView("products");
	}
	
	@RequestMapping(value = "/productDisplay/{productId}", method = RequestMethod.GET)
public ModelAndView prodDisplay(@PathVariable("productId") int productId, Model m, Principal principal) {
	if (principal != null) {
		Customer customer = customerDao.getUserDetails(principal.getName());
		Cart cart = customer.getCart();
		m.addAttribute("cart",cart);
		m.addAttribute(customer);
	}

	List<Category> listcategories = categoryDao.retreiveAllCategories();
	m.addAttribute("catlist", listcategories);

	Product product = productDao.getProduct(productId);
	m.addAttribute(product);
	return new ModelAndView("productDisplay");
}

	@RequestMapping(value="/CategorizedProducts/{cid}", method = RequestMethod.GET)
	public ModelAndView catproducts(@PathVariable("cid") int cid, Model m, Principal principal)
	{
		if(principal!=null)
		{
			Customer customer = customerDao.getUserDetails(principal.getName());
			m.addAttribute(customer);
			Cart cart = customer.getCart();
			m.addAttribute("cart",cart);
			m.addAttribute(customer);
		}
		List<Category> listcat = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist",listcat);
		
		Category category = categoryDao.getCategory(cid);
		Collection<Product> products = category.getProducts();
		m.addAttribute("catproductlist",products);
		return new ModelAndView("CategorizedProducts");
	}

}
