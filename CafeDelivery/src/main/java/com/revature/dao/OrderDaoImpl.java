package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.OrderView;
import com.revature.models.Orders;
import com.revature.utils.CafeConnection;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void insertOrder(Orders o) {
		Session ses = CafeConnection.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(o);
		tx.commit();
	}

	@Override
	public List<OrderView> getOrderByCustomerId(int cid) {
		Session ses = CafeConnection.getSession();
//		ses.beginTransaction().commit();
//		orderList = ses.createQuery("from order_view where customerId = :id", OrderView.class).setInteger("id", cid)
//				.list();
//		orderList = ses.createQuery("from order_view where customerId = :id", OrderView.class).setParameter("id", cid)
//				.list();
		List<OrderView> orders = new ArrayList<>();
//		OrderView orderview = ses.get(OrderView.class, cid);
//		orders = ses.createQuery("from OrderView where customerId = " + cid, OrderView.class).list();
		orders = ses.createNativeQuery(
				"select o.order_id, o.order_date, o.c_id, c.c_firstname, c.c_lastname, od.item_id, cm.item_name, cm.item_price from orders o"
						+ "	inner join customers c on c.c_id = o.c_id"
						+ "		inner join order_details od on od.order_id = o.order_id"
						+ "		inner join cafe_menu cm on cm.item_id = od.item_id where o.c_id =" + cid,
				OrderView.class).list();

//		System.out.println("orderview: " + orders);

//		orders.add(orderview);
//		for (OrderView o : orderview) {
//			orders.add(o);
//		}

		return orders;
	}

}
