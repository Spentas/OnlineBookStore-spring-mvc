package com.spentas.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spentas.domain.Customer;
import com.spentas.domain.Order;
import com.spentas.services.AccountsService;
import com.spentas.services.CustomerNotFoundException;

@Component
public class OrderFlowActions  
{
	@Autowired
	private AccountsService accounts;
	
	public Customer findCustomer(String id) throws CustomerNotFoundException
	{
			Customer requiredCustomer = accounts.findCustomer(id);
			return requiredCustomer;

	}
}
