package com.revature.dao;

import java.util.List;

import com.revature.models.Orders;

public interface OrderDao {

	public void insertOrder(Orders o);

	public List<Orders> getOrdersByCustomerId(int cId);

}
