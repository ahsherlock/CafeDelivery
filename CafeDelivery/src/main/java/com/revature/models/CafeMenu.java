package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cafe_menu")
public class CafeMenu {

	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.AUTO) // Might be Identify
	private int itemId;

	@Column(name = "item_name", nullable = false, unique = true)
	private String itemName;

	@Column(name = "item_price", nullable = false)
	private double itemPrice;

//	@ManyToMany(mappedBy = "cafeMenu")
//	private Set<Orders> orders = new HashSet<>();

	public CafeMenu() {
		super();
	}

//	public CafeMenu(int itemId, String itemName, double itemPrice, Set<Orders> orders) {
//		super();
//		this.itemId = itemId;
//		this.itemName = itemName;
//		this.itemPrice = itemPrice;
//		this.orders = orders;
//	}

	public CafeMenu(int itemId, String itemName, double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
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
		return "CafeMenu [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}

//	public Set<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<Orders> orders) {
//		this.orders = orders;
//	}

//	@Override
//	public String toString() {
//		return "CafeMenu [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", orders="
//				+ orders + "]";
//	}

}
