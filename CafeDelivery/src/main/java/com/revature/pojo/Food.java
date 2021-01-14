package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Food {

	@Id
	@Column(name = "food_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;

	@Column(name = "food_name", unique = true, nullable = false)
	private String foodName;

	@Column(name = "food_price", nullable = false)
	private double foodPrice;

	public Food() {
		super();
	}

	public Food(int foodId, String foodName, double foodPrice) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
	}

}
