package com.revature.service;

import java.util.List;

import com.revature.pojo.Customer;
import com.revature.pojo.Orders;

public class Service {
//	private static  CustomerDao cDao = new CustomerDaoImpl();
//	private static OrdersDao oDao = new OrdersDaoImpl();

	// Get All Customers (For validation and authentication)
	public List<Customer> getAllUsers() {
		return cDao.getAllUsers();
	}

	// Get Customer by Email
	public Customer getUserByUsername(String username) {
		if (!(cDao.selectEmployeeByEmail(username) == null)) {
			return cDao.selectEmployeeByEmail(username);
		} else {
			return null;
		}
	}

	// Register new Customer
	public boolean insertCustomer(Customer c) {
		System.out.println("reached Service");
		if (cDao.insertCustomer(c)) {
			System.out.println("Successfully Registered!");
			return true;
		} else {
			System.out.println("User with that email already exists!");
			return false;
		}
	}

	// Get all Orders by Username
	public List<Orders> getOrdersByUsername(String username) {
		System.out.println("Reached Service");
		return oDao.getOrdersByUsername(username);
	}

	// Insert new Order
	public boolean insertOrder(Orders o) {
		System.out.println("Reached service");
		if (oDao.insertOrder(o)) {
			System.out.println("Service: Order Successfully Created: " + o);
			return true;
		} else {
			System.out.println("Service: Order Creation Failed");
			return false;
		}
	}
}
