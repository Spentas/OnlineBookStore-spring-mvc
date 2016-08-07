package com.spentas.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spentas.domain.Book;
import com.spentas.services.BookService;

@Controller
@RequestMapping("/addNewBook")
public class CreateBookController 
{
	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("add-new-book", "book", new Book());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processForm(@Valid Book newBook, Errors result) 
	{
		if (result.hasErrors())
		{
			return new ModelAndView("add-new-book", "book", newBook);
		}
		bookService.registerNewBook(newBook);
		return new ModelAndView("book-added", "title", newBook.getTitle());
	}

}
