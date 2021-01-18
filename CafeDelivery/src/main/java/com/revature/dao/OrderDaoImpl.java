package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.pojo.Customer;
import com.revature.pojo.Menu;
import com.revature.pojo.Orders;
import com.revature.util.HibernateUtil;

public class OrderDaoImpl implements OrderDao {

//	@Override
//	public List<Integer> getOrdersByCustomerId(int id) {
//		Session ses = HibernateUtil.getSession();
//		List<Orders> orderList = null;
//		orderList = ses.createQuery("from Orders where customerOrder = :id", Orders.class).setInteger("id", id).list();
//		List<Integer> orderNumbers = new ArrayList<Integer>();
//		for (Orders o : orderList) {
//			orderNumbers.add(o.getOrderId());
//		}
//		return orderNumbers;
//	}

	@Override
	public List<Object> getOrdersByCustomerId(int id) {
		Session ses = HibernateUtil.getSession();
		List<Orders> orderList = null;
		orderList = ses.createQuery("from Orders where customerOrder = :id", Orders.class).setInteger("id", id).list();
		List<Object> obj = new ArrayList<>();
		List<List<Menu>> orderNumbers = new ArrayList<>();
		List<Customer> orderNumbers1 = new ArrayList<>();
		List<Integer> orderNumbers2 = new ArrayList<>();

		for (Orders o : orderList) {
			orderNumbers.add(o.getMenu());
			orderNumbers1.add(o.getCustomerOrder());
			orderNumbers2.add(o.getOrderId());
			obj.add(orderNumbers);
			obj.add(orderNumbers1);
			obj.add(orderNumbers2);
		}
		return obj;
	}

	@Override
	public List<Menu> getOrderByOrderId(int id) {
		Session ses = HibernateUtil.getSession();
		List<Menu> oList = new ArrayList<>();

		oList = ses
				.createQuery("select menu from Orders ord join ord.item_name menu where ord.orderId = :id", Menu.class)
				.setInteger("id", id).list();

		return oList;
	}

	@Override
	public void insertOrder(Orders o) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(o);
		tx.commit();
	}
	
	@Override
	public List<Menu> getMenu() {
		Session session = HibernateUtil.getSession();
		List<Menu> menuList = new ArrayList<>();
		menuList = session.createQuery("from menu",Menu.class).list();
		return menuList;
		
		
	}

}

/**
 * 
 * public Orders(int orderId, Customer customerOrder, List<Menu> item_id
 * 
 * select ot.order_id, m.item_id, m.item_name, m.item_price from order_table ot
 * left outer join order_table_menu otm on ot.order_id = otm.orders_order_id
 * left outer join menu m on m.item_id = otm.item_id;
 */