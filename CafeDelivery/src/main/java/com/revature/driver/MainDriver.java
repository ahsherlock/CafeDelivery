package com.revature.driver;


import java.util.ArrayList;
import java.util.List;

import com.revature.dao.*;
import com.revature.pojo.*;

public class MainDriver {

	public static void main(String[] args) {
		CustomerDao cDao = new CustomerDaoImpl();
		OrderDao oDao = new OrderDaoImpl();
		
		Customer cust = new Customer(1, "user1", "pass", "first", "last" );
        cDao.insertCustomer(cust);


        Menu item1 = new Menu(0,"sushi", 2000);
        Menu item2 = new Menu(0,"salmon", 2);
        Menu item3 = new Menu(0,"steak", 15);

        List<Menu> menuList = new ArrayList<>();
        menuList.add(item1);
        menuList.add(item2);
        menuList.add(item3);

        Orders ord = new Orders(1,cust, menuList);
        Orders ord1 = new Orders(2,cust, menuList);
        Orders ord2 = new Orders(3,cust, menuList);
        
        oDao.insertOrder(ord);
        oDao.insertOrder(ord1);
        oDao.insertOrder(ord2);
        
        System.out.println("User by username reutrns: " + cDao.getUserByUsername("user1"));
        System.out.println(oDao.getOrderByOrderId(1));
        System.out.println(oDao.getOrderByOrderId(2));
        System.out.println(oDao.getOrderByOrderId(3));
 
        System.out.println(cDao.insertCustomer(new Customer(2, "temp", "temp", "temp", "temp" )));
        System.out.println("User by username reutrns: " + cDao.getUserByUsername("temp"));
        
        oDao.insertOrder(new Orders(4,cust, menuList));
 
        System.out.println(oDao.getOrdersByCustomerId(1));

        
        
	}
	
}
