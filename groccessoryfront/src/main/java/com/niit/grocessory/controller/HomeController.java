package com.niit.grocessory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.groccessory.dao.CustomerDao;
import com.niit.groccessory.model.Customer;

@Controller
public class HomeController {

	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("/")
	public ModelAndView Home() {

		ModelAndView m = new ModelAndView("index");
		return m;

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
				customerDao.addCustomer(customer);
				return "redirect:/";
			}
		}
	}
}
