package com.revature.pojo;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Orders {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_fk")
	private Customer customerOrder;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Menu> item_id;

	public Orders() {
		super();
	}

	public Orders(int orderId, Customer customerOrder, List<Menu> item_id) {
		super();
		this.orderId = orderId;
		this.customerOrder = customerOrder;
		this.item_id = item_id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(Customer customerOrder) {
		this.customerOrder = customerOrder;
	}

	public List<Menu> getItem_id() {
		return item_id;
	}

	public void setItem_id(List<Menu> item_id) {
		this.item_id = item_id;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerOrder=" + customerOrder + ", item_id=" + item_id + "]";
	}
	
	
	



}
