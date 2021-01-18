package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Customers;
import com.revature.util.CafeConnection;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void insertCustomer(Customers c) {
		Session ses = CafeConnection.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(c);
		tx.commit();
	}

	@Override
	public Customers getUserByUsername(String username) {
		Session ses = CafeConnection.getSession();

		List<Customers> cList = new ArrayList<Customers>();
		Query query = ses.createQuery("from Customers c where c.username = :username");
		query.setParameter("username", username);
		cList = query.getResultList();

		if (cList.get(0) != null) {
			return cList.get(0);
		} else {
			return null;
		}
	}

}
