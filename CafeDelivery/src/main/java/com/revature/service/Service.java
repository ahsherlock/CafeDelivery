package com.revature.service;

import java.util.List;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.OrderDao;
import com.revature.dao.OrderDaoImpl;
import com.revature.pojo.Customer;
import com.revature.pojo.Menu;
import com.revature.pojo.Orders;

public class Service {
	private static CustomerDao cDao = new CustomerDaoImpl();
	private static OrderDao oDao = new OrderDaoImpl();

	// Get All Customers (For validation and authentication)
//	public List<Customer> getAllUsers() {
//		return cDao.getAllUsers();
//	}

	// Get Customer by Email
	public Customer getUserByUsername(String username) {
		Customer c = cDao.getUserByUsername(username);
		// removed redundancies
		if (c != null) {
			return c;
		} else {
			return null;
		}
	}

	// Register new Customer
	public boolean insertCustomer(Customer c) {
		System.out.println("reached Service");
		// no longer using boolean in insertCustomer, checking is now done here
//		if (cDao.getUserByUsername(c.getUsername()) != null) {
//			System.out.println("Successfully Registered!");
//			return true;
//		} else {
//			System.out.println("User with that email already exists!");
//			return false;
//		}
		cDao.insertCustomer(c);
		return true;
	}

	// Get all Orders by Username
	public List<Object> getOrdersByCustomerId(int id) {
		System.out.println("Reached Service");
		return oDao.getOrdersByCustomerId(id);
	}

	public List<Menu> getOrderByOrderId(int id) {
		System.out.println("Reached Service");
		return oDao.getOrderByOrderId(id);
	}

	// Insert new Order
	public boolean insertOrder(Orders o) {
		System.out.println("Reached service");
		// no longer using boolean in insertOrder, checking is now done here
		if (oDao.getOrderByOrderId(o.getOrderId()) != null) {
			System.out.println("Service: Order Successfully Created: " + o);
			return true;
		} else {
			System.out.println("Service: Order Creation Failed");
			return false;
		}
	}
}
