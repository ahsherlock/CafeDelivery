package com.revature.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {

	@Id
	@Column(name = "c_id")
	@GeneratedValue(strategy = GenerationType.AUTO) // Might be Identify
	private int id;

	@Column(name = "c_firstname", nullable = false)
	private String firstName;

	@Column(name = "c_lastname", nullable = false)
	private String lastName;

	@Column(name = "c_username", nullable = false, unique = true)
	private String username;

	@Column(name = "c_password", nullable = false)
	private String password;

	@OneToMany(mappedBy = "customers")
	private Set<Orders> orders = new HashSet<>();

	public Customers(int id, String firstName, String lastName, String username, String password, Set<Orders> orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.orders = orders;
	}

	public Customers() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", orders=" + orders + "]";
	}

}
