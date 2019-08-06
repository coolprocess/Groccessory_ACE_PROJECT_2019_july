package com.niit.grocessory.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.groccessory.dao.CartDao;
import com.niit.groccessory.dao.CartItemsdao;
import com.niit.groccessory.dao.CustomerDao;
import com.niit.groccessory.dao.ProductDao;
import com.niit.groccessory.model.Cart;
import com.niit.groccessory.model.CartItems;
import com.niit.groccessory.model.Customer;
import com.niit.groccessory.model.Product;
import java.util.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ProductDao productDao;
	@Autowired
	CustomerDao customerDao;

	@Autowired
	CartDao cartDao;
	@Autowired
	CartItemsdao cartitemDao;

	@RequestMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable("productId") int productId, Model m,
			@RequestParam(value = "quantity") int quantity, Principal principal) {
		System.out.println(principal);
		Product product = productDao.getProduct(productId);
		Customer customer = customerDao.getUserDetails(principal.getName());
		Cart cart = customer.getCart();
		CartItems cartItems = cartitemDao.getProduct(productId, cart.getCartId());
		if (cartItems == null) {
			cartItems = new CartItems();
			cartItems.setProduct(product);
			cartItems.setCartItemQuantity(quantity);
			cartItems.setCart(cart);
			cartItems.setCartItemPrice(cartItems.getCartItemQuantity() * product.getProductPrice());
			ArrayList<CartItems> itemsList = new ArrayList<CartItems>();
			itemsList.add(cartItems);
			cart.setCartQuantity(cart.getCartQuantity() + cartItems.getCartItemQuantity());
			cart.setTotalCartPrice(cart.getTotalCartPrice() + cartItems.getCartItemPrice());
			cart.setCartitems(itemsList);
			m.addAttribute("cartItems", itemsList);
			cartitemDao.addCartItems(cartItems);

		} else {
			cartItems.setProduct(product);

			cartItems.setCartItemPrice(cartItems.getCartItemPrice() + (quantity * product.getProductPrice()));

			cartItems.setCartItemQuantity(cartItems.getCartItemQuantity() + quantity);

			ArrayList<CartItems> itemsList = new ArrayList<CartItems>();

			itemsList.add(cartItems);

			cart.setCartQuantity(cart.getCartQuantity() + cartItems.getCartItemQuantity());

			cart.setTotalCartPrice(cart.getTotalCartPrice() + (quantity * product.getProductPrice()));

			cart.setCartitems(itemsList);

			m.addAttribute("cartItems", itemsList);
			cartitemDao.updateCartItems(cartItems);
		}

		cartDao.updateCart(cart);

		m.addAttribute(product);

		m.addAttribute(cart);

		return "redirect:/customer/myCart";
	}

	@RequestMapping("/myCart")
	public String myCart(Model m, Principal principal)

	{

		System.out.println(principal);

		Customer customer = customerDao.getUserDetails(principal.getName());
		Cart cart = customer.getCart();

		List<CartItems> cartItems = cart.getCartitems();
		m.addAttribute("cartItems", cartItems);

		m.addAttribute(cart);

		return "mycart";

	}

	@RequestMapping(value = "/editCartItems/{cartItemId}")
	public String editcartItem(@PathVariable(value = "cartItemId") int id, Model m,
			@RequestParam(value = "quantity") int quantity, Principal p)

	{

		CartItems cartItem = cartitemDao.getCartItems(id);

		Customer customer = customerDao.getUserDetails(p.getName());

		Cart cart = customer.getCart();

		cart.setCartQuantity(cart.getCartQuantity() - cartItem.getCartItemQuantity());

		cart.setTotalCartPrice(cart.getTotalCartPrice() - cartItem.getCartItemPrice());

		Product product = cartItem.getProduct();

		cartItem.setCartItemQuantity(quantity);

		cartItem.setCartItemPrice(quantity * product.getProductPrice());

		cart.setCartId(cartItem.getCart().getCartId());

		cart.setCartQuantity(cart.getCartQuantity() + cartItem.getCartItemQuantity());

		cart.setTotalCartPrice(cart.getTotalCartPrice() + cartItem.getCartItemPrice());

		cartitemDao.updateCartItems(cartItem);

		customer.setCart(cart);

		cartDao.updateCart(cart);

		return "redirect:/customer/myCart";

	}

	@RequestMapping(value = "deleteCartItems/{cartItemId}/cartItem")

	public String deleteCartItem(@PathVariable("cartItemId") int id, Model m, Principal p)

	{

		CartItems cartItem = cartitemDao.getCartItems(id);

		Customer customer = customerDao.getUserDetails(p.getName());

		Cart cart = customer.getCart();

		cart.setCartId(cartItem.getCart().getCartId());

		cart.setCartQuantity(cart.getCartQuantity() - cartItem.getCartItemQuantity());

		cart.setTotalCartPrice(cart.getTotalCartPrice() - cartItem.getCartItemPrice());

		customer.setCart(cart);

		cartDao.updateCart(cart);

		cartitemDao.deletCartItems(cartItem);

		return "redirect:/customer/myCart";

	}

	
}
