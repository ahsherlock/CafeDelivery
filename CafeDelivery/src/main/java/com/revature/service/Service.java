package com.revature.service;

import java.util.List;

import com.revature.dao.CafeMenuDao;
import com.revature.dao.CafeMenuDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.OrderDao;
import com.revature.dao.OrderDaoImpl;
import com.revature.models.CafeMenu;
import com.revature.models.Customers;
import com.revature.models.Orders;

public class Service {
	private static CustomerDao cDao = new CustomerDaoImpl();
	private static OrderDao oDao = new OrderDaoImpl();
	private static CafeMenuDao cmDao = new CafeMenuDaoImpl();

	// Get Customer by Email
	public Customers getUserByUsername(String username) {
		Customers c = cDao.getUserByUsername(username);
		// removed redundancies
		if (c != null) {
			return c;
		} else {
			return null;
		}
	}

	// Register new Customer
	public boolean insertCustomer(Customers c) {
		System.out.println("reached Service");
		// no longer using boolean in insertCustomer, checking is now done here
		cDao.insertCustomer(c);
		return true;

//		if (cDao.getUserByUsername(c.getUsername()) == null) {
//			System.out.println("Successfully Registered!");
//			return true;
//		} else {
//			System.out.println("User with that email already exists!");
//			return false;
//		}
	}

	// Get all Orders by Username
	public List<Orders> getOrdersByCustomerId(int id) {
		System.out.println("Reached Service");
		return oDao.getOrdersByCustomerId(id);
	}

//	public List<Menu> getOrderByOrderId(int id) {
//		System.out.println("Reached Service");
//		return oDao.getOrderByOrderId(id);
//	}

	// Insert new Order
	public void insertOrder(Orders o) {
		System.out.println("Reached service");
		// no longer using boolean in insertOrder, checking is now done here
//		if (oDao.getOrdersByOrderId(o.getId()) != null) {
//			System.out.println("Service: Order Successfully Created: " + o);
//			return true;
//		} else {
//			System.out.println("Service: Order Creation Failed");
//			return false;

//		}
		oDao.insertOrder(o);
	}

	public List<CafeMenu> getMenu() {
		return cmDao.getMenu();
	}
}
