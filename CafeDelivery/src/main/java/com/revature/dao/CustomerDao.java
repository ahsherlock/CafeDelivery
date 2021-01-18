package com.revature.dao;

import com.revature.models.Customers;

public interface CustomerDao {

	/**
	 * 
	 * @param Customer
	 * @return True if the customer is created, false if not
	 */
	public void insertCustomer(Customers c);

	/**
	 * 
	 * @param String username
	 * @return returns a Customer Object if there is a matching username in the
	 *         database
	 */
	public Customers getUserByUsername(String username);

}
