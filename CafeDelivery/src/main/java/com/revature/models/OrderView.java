package com.revature.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_view")
public class OrderView {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO) // Might be Identify
	private int orderId;

	@Column(name = "order_date")
	private LocalDate orderDate;

	@Column(name = "c_id")
	private int customerId;

	@Column(name = "c_firstname")
	private String firstName;

	@Column(name = "c_lastname")
	private String lastName;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_price")
	private double itemPrice;

	public OrderView(int orderId, LocalDate orderDate, int customerId, String firstName, String lastName, int itemId,
			String itemName, double itemPrice) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public OrderView() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "OrderView [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", itemId=" + itemId + ", itemName="
				+ itemName + ", itemPrice=" + itemPrice + "]";
	}

}
