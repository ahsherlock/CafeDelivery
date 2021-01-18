package com.revature.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO) // Might be Identify
	private int id;

	@Column(name = "order_date")
	private LocalDate orderDate;

	@ManyToOne
	@JoinColumn(name = "c_id", nullable = false)
	private Customers customers;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "order_details", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
			@JoinColumn(name = "item_id") })
	private List<CafeMenu> cafeMenu = new ArrayList<>();

	public Orders(int id, LocalDate orderDate, Customers customers, List<CafeMenu> cafeMenu) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.customers = customers;
		this.cafeMenu = cafeMenu;
	}


	public Orders() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public List<CafeMenu> getCafeMenu() {
		return cafeMenu;
	}

	public void setCafeMenu(List<CafeMenu> cafeMenu) {
		this.cafeMenu = cafeMenu;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", customers=" + customers + ", cafeMenu=" + cafeMenu
				+ "]";
	}

}
