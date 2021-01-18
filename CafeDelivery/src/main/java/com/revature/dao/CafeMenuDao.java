package com.revature.dao;

import java.util.List;

import com.revature.models.CafeMenu;

public interface CafeMenuDao {

	public void insertMenu(CafeMenu cm);
	
	public List<CafeMenu> getMenu();
	
}
