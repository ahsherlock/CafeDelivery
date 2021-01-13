package com.revature.dao;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.pojo.Customer;
import com.revature.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		List<Customer> cList = new ArrayList<Customer>();
		Query query = ses.createQuery("from Customer where description = :username");
        query.setParameter("username", username);
        cList.add((Customer) query.getResultList());
		return cList.get(0);
	}

	@Override
	public boolean insertCustomer(Customer c) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(c);
		tx.commit();
		ses.close();
		return false;
	}

}
