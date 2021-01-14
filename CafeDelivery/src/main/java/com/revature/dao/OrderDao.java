package com.revature.dao;

import java.util.List;

import com.revature.pojo.Menu;
import com.revature.pojo.Orders;

public interface OrderDao {
	
	
	/**
	 * retrieves a list of all orders placed by the user
	 * 
	 */
	public List<Integer> getOrdersByCustomerId(int id);
	
	/**
	 * Selects an order from the current user by the order id
	 * 
	 */
	public List<Menu> getOrderByOrderId(int id);
	
	/**
	 * Inserts an order into the database
	 */
	public void insertOrder(Orders o);
		
	
}
