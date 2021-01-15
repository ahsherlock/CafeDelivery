package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Customers;
import com.revature.utils.CafeConnection;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void insertCustomer(Customers c) {
		Session ses = CafeConnection.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(c);
		tx.commit();
	}

}
