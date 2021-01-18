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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;

	@Column(name = "item_name", nullable = false, unique = false)
	private String itemName;

	@Column(name = "item_price", nullable = false)
	private double itemPrice;

	public CafeMenu() {
		super();
	}

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

}
