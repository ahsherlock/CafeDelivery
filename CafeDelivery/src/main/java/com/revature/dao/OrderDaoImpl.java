package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Orders;
import com.revature.util.CafeConnection;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void insertOrder(Orders o) {
		Session ses = CafeConnection.getSession();

		Transaction tx = ses.beginTransaction();
		ses.save(o);
		tx.commit();
//		ses.close();
	}

	@Override
	public List<Orders> getOrdersByCustomerId(int cId) {
		Session ses = CafeConnection.getSession();

		List<Orders> orders = new ArrayList<>();
		orders = ses.createNativeQuery(
				"select o.order_id, o.order_date, o.c_id, c.c_firstname, c.c_lastname, od.item_id, cm.item_name, cm.item_price from orders o"
						+ "	inner join customers c on c.c_id = o.c_id"
						+ "	inner join order_details od on od.order_id = o.order_id"
						+ "	inner join cafe_menu cm on cm.item_id = od.item_id where c.c_id =" + cId,
				Orders.class).list();

		return orders;
	}

}
