package com.revature.dao;

import com.revature.pojo.Customer;

public interface CustomerDao {
	/**
	 * 
	 * @param String username
	 * @return	returns a Customer Object if there is a matching username in the database
	 */
	public Customer getUserByUsername(String username);
	/**
	 * 
	 * @param Customer 
	 * @return	True if the customer is created, false if not
	 */
	public boolean insertCustomer(Customer c);
		
}
