package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.revature.pojo.Customer;
import com.revature.pojo.Menu;
import com.revature.pojo.Orders;
import com.revature.util.HibernateUtil;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<List<Menu>> getOrdersByCustomerId(int id) {
		Session ses = HibernateUtil.getSession();
		List<Orders> orderList = null;
		orderList = ses.createQuery("from Orders where customerOrder = :id", Orders.class).setInteger("id", id).list();
		List<List<Menu>> orderNumbers = new ArrayList<>();
		for (Orders o : orderList) {
			orderNumbers.add(o.getMenu());
			System.out.println(o.getCustomerOrder());
		}
		return orderNumbers;
	}

	@Override
	public List<Menu> getOrderByOrderId(int id) {
		Session ses = HibernateUtil.getSession();
		List<Menu> oList = new ArrayList<>();
		
		oList = ses.createQuery("select menu from Orders ord join ord.item_name menu where ord.orderId = :id", Menu.class).setInteger("id", id).list(); 
		
		return oList;
	}

	@Override
	public void insertOrder(Orders o) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(o);
		tx.commit();
	}

}


/**
	
	public Orders(int orderId, Customer customerOrder, List<Menu> item_id
	
	select ot.order_id, m.item_id, m.item_name, m.item_price
	from order_table ot left outer join order_table_menu otm on 
	ot.order_id = otm.orders_order_id
	left outer join menu m on m.item_id = otm.item_id;
*/