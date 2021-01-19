package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.OrderDao;
import com.revature.dao.OrderDaoImpl;
import com.revature.pojo.Customer;
import com.revature.pojo.Menu;
import com.revature.pojo.Orders;
import com.revature.service.Service;

public class MainDriver {

	public static void main(String[] args) {

		CustomerDao cDao = new CustomerDaoImpl();
		OrderDao oDao = new OrderDaoImpl();
		Service uServe = new Service();
//		
		/*
		Customer cust = new Customer(1, "temp", "temp", "temp", "temp");
		Customer cust2 = new Customer(2, "123", "123", "123", "123");
		cDao.insertCustomer(cust);
		cDao.insertCustomer(cust2);
//

		Menu item1 = new Menu("sushi", 2000);
		Menu item2 = new Menu("salmon", 2);
		Menu item3 = new Menu("steak", 15);
//
		List<Menu> menuList = new ArrayList<>();
		menuList.add(item1);
		menuList.add(item2);
		menuList.add(item3);

		List<Menu> menuList2 = new ArrayList<>();
		menuList2.add(item1);

		Orders ord = new Orders(1, cust, menuList);
		System.out.println(ord);
		Orders ord1 = new Orders(2, cust, menuList);
		Orders ord2 = new Orders(3, cust, menuList);
		Orders ord3 = new Orders(4, cust2, menuList2);

		oDao.insertOrder(ord);
		oDao.insertOrder(ord1);
		oDao.insertOrder(ord2);
		oDao.insertOrder(ord3);
//        
//		System.out.println("User by username reutrns: " + cDao.getUserByUsername("user1"));
		System.out.println(oDao.getOrderByOrderId(1));
		System.out.println(oDao.getOrderByOrderId(2));
		System.out.println(oDao.getOrderByOrderId(3));
// 
//		System.out.println(cDao.insertCustomer(new Customer(2, "temp", "temp", "temp", "temp")));
//		System.out.println("User by username reutrns: " + cDao.getUserByUsername("temp"));

		oDao.insertOrder(new Orders(4, cust, menuList));

		System.out.println(oDao.getOrdersByCustomerId(1));
		*/

//		OrderDao oDao = new OrderDaoImpl();
//		System.out.println(oDao.getOrdersByCustomerId(1));
		System.out.println(uServe.getOrdersByCustomerId(1));

//		System.out.println(oDao.getOrdersByCustomerId(2));
	}

}
