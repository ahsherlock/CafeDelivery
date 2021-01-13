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

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Integer> getOrdersByCustomerId(int id) {
		Session ses = HibernateUtil.getSession();
		Query query = ses.createQuery("select distinct order_id from order_table where customer_fk = :id");
		 query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public List<Menu> getOrderByOrderId(int id) {
		Session ses = HibernateUtil.getSession();
		List<Orders> oList = new ArrayList<Orders>();
		Query query = ses.createQuery("select distinct m.item_id, m.item_name, m.item_price"
				+ "    from order_table ot inner join order_table_menu otm on "
				+ "    ot.order_id = :orders_order_id "
				+ "    inner join menu m on m.item_id = otm.item_id_item_id;"); 
        query.setParameter("orders_order_id", id);
		Orders o;
		List<Menu> result = query.getResultList();
		return result;
	}

	@Override
	public void insertOrder(Orders o) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(o);
		tx.commit();
		ses.close();
	}

}


/**
	
	public Orders(int orderId, Customer customerOrder, List<Menu> item_id
	
	select ot.order_id, m.item_id, m.item_name, m.item_price
	from order_table ot left outer join order_table_menu otm on 
	ot.order_id = otm.orders_order_id
	left outer join menu m on m.item_id = otm.item_id;
*/