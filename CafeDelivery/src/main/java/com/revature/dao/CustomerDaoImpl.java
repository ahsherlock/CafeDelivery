package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.pojo.Customer;
import com.revature.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();

		/**
			Explanation: The method returns an User object from the database, we append an ArrayList<Customer> with the results we got 
			from our query, then select the first result, if not null. 
			Input: String of username
			Output: A Customer object || null
		 */
		List<Customer> cList = new ArrayList<Customer>();
		Query query = ses.createQuery("from Customer c where c.username = :username");
		query.setParameter("username", username);
		cList = query.getResultList();

		if (cList.get(0) != null) {
			return cList.get(0);
		} else {
			return null;
		}

	}
	
	/**
		Explanation: The method inserts an Customer object to the database using session.save, will currently return false no matter what. 
		Input: A Customer object
		Output: false0
	 */

	@Override
	public boolean insertCustomer(Customer c) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(c);
		tx.commit();
		return false;
	}

}
