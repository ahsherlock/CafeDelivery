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

public class MainDriver {

	public static void main(String[] args) {
		CustomerDao cDao = new CustomerDaoImpl();
		OrderDao oDao = new OrderDaoImpl();
//		
		Customer cust = new Customer(1, "temp", "temp", "temp", "temp");
		cDao.insertCustomer(cust);
//

		Menu item1 = new Menu("sushi", 2000);
		Menu item2 = new Menu("salmon", 2);
//        Menu item3 = new Menu("steak", 15);
//
		List<Menu> menuList = new ArrayList<>();
		menuList.add(item1);
		menuList.add(item2);
//        menuList.add(item3);

		Orders ord = new Orders(1, cust, menuList);
		System.out.println(ord);
//        Orders ord1 = new Orders(2,cust, menuList);
//        Orders ord2 = new Orders(3,cust, menuList);

		oDao.insertOrder(ord);
//        oDao.insertOrder(ord1);
//        oDao.insertOrder(ord2);
//        
//        System.out.println("User by username reutrns: " + cDao.getUserByUsername("user1"));
//        System.out.println(oDao.getOrderByOrderId(1));
//        System.out.println(oDao.getOrderByOrderId(2));
//        System.out.println(oDao.getOrderByOrderId(3));
// 
//		System.out.println(cDao.insertCustomer(new Customer(2, "temp", "temp", "temp", "temp")));
//        System.out.println("User by username reutrns: " + cDao.getUserByUsername("temp"));
//        
//        oDao.insertOrder(new Orders(4,cust, menuList));
// 
//        System.out.println(oDao.getOrdersByCustomerId(1));

	}

}
