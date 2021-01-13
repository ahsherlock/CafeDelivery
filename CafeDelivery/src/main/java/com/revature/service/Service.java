package com.revature.service;

import java.util.List;

import com.revature.pojo.Customer;
import com.revature.pojo.Orders;
import com.revature.dao.*;

public class Service {
	private static  CustomerDao cDao = new CustomerDaoImpl();
	private static OrderDao oDao = new OrderDaoImpl();

	// Get All Customers (For validation and authentication)
//	public List<Customer> getAllUsers() {
//		return cDao.getAllUsers();
//	}

	// Get Customer by Email
	public Customer getUserByUsername(String username) {
		Customer c = cDao.getUserByUsername(username);
		//removed redundancies 
		if (c != null) {
			return c;
		} else {
			return null;
		}
	}

	// Register new Customer
	public boolean insertCustomer(Customer c) {
		System.out.println("reached Service");
		//no longer using boolean in insertCustomer, checking is now done here
		if (cDao.getUserByUsername(c.getUsername()) != null) {
			System.out.println("Successfully Registered!");
			return true;
		} else {
			System.out.println("User with that email already exists!");
			return false;
		}
	}

	// Get all Orders by Username
	public List<Integer> getOrdersByCustomerId(int id) {
		System.out.println("Reached Service");
		return oDao.getOrdersByCustomerId(id);
	}

	// Insert new Order
	public boolean insertOrder(Orders o) {
		System.out.println("Reached service");
		//no longer using boolean in insertOrder, checking is now done here
		if (oDao.getOrderByOrderId(o.getOrderId()) != null) {
			System.out.println("Service: Order Successfully Created: " + o);
			return true;
		} else {
			System.out.println("Service: Order Creation Failed");
			return false;
		}
	}
}
