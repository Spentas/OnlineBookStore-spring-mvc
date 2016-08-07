package com.spentas.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spentas.domain.Book;
import com.spentas.domain.ShoppingCart;
import com.spentas.services.BookService;

@Controller
@Scope("request")
public class CartManagementController 
{
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ShoppingCart cart;

	@RequestMapping("/addToCart")
	public ModelAndView addToCart(@RequestParam("id") int id)
	{
		Book requiredBook = bookService.getBookById(id);
		cart.addItem(requiredBook);
		return new ModelAndView("bookAddedToCart", "title", requiredBook.getTitle());
	}
	
	@RequestMapping("/viewCart")
	public ModelAndView viewCart()
	{
		List<Book> allBooks = cart.getAllItems();		
		return new ModelAndView("cartContents","cart",allBooks);
	}
}
