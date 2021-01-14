package com.revature.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	
	@Id
	@Column(name="item_name", unique=true, nullable = false)
	private String itemName;
	
	@Column(name="item_price", nullable = false)
	private double itemPrice;
	
	public Menu() {
		super();
	}

	public Menu(String itemName, double itemPrice) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
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
		return "Menu [itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}
	
	
	

}
