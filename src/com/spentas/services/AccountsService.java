package com.spentas.services;

import java.util.List;

import com.spentas.domain.Book;
import com.spentas.domain.Customer;
import com.spentas.domain.Order;

public interface AccountsService 
{
	public void raiseInvoice(Book requiredBook);
	
	public Customer findCustomer(String id) throws CustomerNotFoundException;
}
