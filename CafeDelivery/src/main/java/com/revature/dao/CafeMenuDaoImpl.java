package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.CafeMenu;
import com.revature.util.CafeConnection;

public class CafeMenuDaoImpl implements CafeMenuDao {

	@Override
	public void insertMenu(CafeMenu cm) {
		Session ses = CafeConnection.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(cm);
		tx.commit();
	}

	@Override
	public List<CafeMenu> getMenu() {
		Session ses = CafeConnection.getSession();
		
		List<CafeMenu> menu = new ArrayList<>();
		menu = ses.createQuery("from CafeMenu", CafeMenu.class).list();
		
		return menu;
	}

}
