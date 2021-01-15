package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.CafeMenu;
import com.revature.utils.CafeConnection;

public class CafeMenuDaoImpl implements CafeMenuDao {

	@Override
	public void insertMenu(CafeMenu cm) {
		Session ses = CafeConnection.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(cm);
		tx.commit();
	}

}
