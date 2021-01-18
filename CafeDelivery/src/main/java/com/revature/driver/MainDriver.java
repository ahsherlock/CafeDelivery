package com.revature.driver;

import java.time.LocalDate;
import java.util.ArrayList;
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

public class MainDriver {

	public static void main(String[] args) {
		CustomerDao cDao = new CustomerDaoImpl();
		OrderDao oDao = new OrderDaoImpl();
		CafeMenuDao cmDao = new CafeMenuDaoImpl();

		/*******************************************
		 * CREATE CUSTOMER
		 **************************************************/
		Customers cust1 = new Customers(0, "Customer1", "Customer1", "user1", "1111");
		cDao.insertCustomer(cust1);
		Customers cust2 = new Customers(0, "Customer2", "Customer2", "user2", "2222");
		cDao.insertCustomer(cust2);

		/*******************************************
		 * CREATE CAFE MENU
		 *************************************************/
		CafeMenu item1 = new CafeMenu(0, "Sushi", 12.69);
		CafeMenu item2 = new CafeMenu(0, "Salmon", 10.58);
		CafeMenu item3 = new CafeMenu(0, "Steak", 11.79);
		CafeMenu item4 = new CafeMenu(0, "Coke", 2.25);
		CafeMenu item5 = new CafeMenu(0, "Water", 1.45);

		cmDao.insertMenu(item1);
		cmDao.insertMenu(item2);
		cmDao.insertMenu(item3);
		cmDao.insertMenu(item4);
		cmDao.insertMenu(item5);

		/*********************************************
		 * CREATE ORDER
		 **************************************************/

		// Prepare order details in ArrayList
		List<CafeMenu> oDetails1 = new ArrayList<>();
		List<CafeMenu> oDetails2 = new ArrayList<>();
		List<CafeMenu> oDetails3 = new ArrayList<>();
		oDetails1.add(item1); // Sushi
		oDetails1.add(item4); // Coke
		oDetails2.add(item3); // Steak
		oDetails2.add(item5); // Water
		oDetails3.add(item2); // Salmon
		oDetails3.add(item5); // Water
		oDetails3.add(item5); // Water

		// Use above ArrayList as a parameter for Orders constructor
		Orders ord1 = new Orders(0, LocalDate.parse("2021-01-10"), cust1, oDetails1);
		Orders ord2 = new Orders(0, LocalDate.parse("2021-01-10"), cust2, oDetails2);
		Orders ord3 = new Orders(0, LocalDate.parse("2021-01-11"), cust1, oDetails3);

		// Send above objects to insertOrder in DAO layer
		oDao.insertOrder(ord1);
		oDao.insertOrder(ord2);
		oDao.insertOrder(ord3);

		/**********************************************
		 * VIEW CAFE MENU
		 *************************************************/
		List<CafeMenu> cMenu = new ArrayList<>();
		cMenu = cmDao.getMenu();
		System.out.println("\nCafe Menu: ");

		System.out.println("Item Name      Item Price");
		for (CafeMenu cm : cMenu) {
			System.out.printf(" %6s         %5.2f \n", cm.getItemName(), cm.getItemPrice());
		}

		/*******************************************
		 * VIEW CUSTOMER ORDERS
		 **********************************************/
		List<Orders> oList = new ArrayList<>();

		// Customer #1 Orders
		oList = oDao.getOrdersByCustomerId(1);
		System.out.println("\nCustomer #1 Orders: ");
		System.out.println(oList);

		int x = -1;
		System.out.println("cId   cName       oId   oDate        iName     iPrice");
		for (Orders o : oList) {
//			System.out.println("This is O: " + o);
			if (x != o.getId()) {
				for (CafeMenu c : o.getCafeMenu()) {
					System.out.println("This is C: " + c);
//					System.out.printf("%2d    %9s    %2d   %10s   %6s    %5.2f \n", o.getCustomers().getId(),
//							o.getCustomers().getFirstName(), o.getId(), o.getOrderDate(), c.getItemName(),
//							c.getItemPrice());
				}
				x = o.getId();
			}
		}

		// Customer #2 Orders
		oList = oDao.getOrdersByCustomerId(2);
		System.out.println("\nCustomer #2 Orders: ");

		x = -1;
		System.out.println("cId   cName       oId   oDate        iName     iPrice");
		for (Orders o : oList) {
			if (x != o.getId()) {
				for (CafeMenu c : o.getCafeMenu()) {
					System.out.printf("%2d    %9s    %2d   %10s   %6s    %5.2f \n", o.getCustomers().getId(),
							o.getCustomers().getFirstName(), o.getId(), o.getOrderDate(), c.getItemName(),
							c.getItemPrice());
				}
				x = o.getId();
			}
		}

	}

}
