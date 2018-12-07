package com.cofeeshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the beverage database table.
 * 
 */
@Entity

public class Beverage implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idbeverage;

	@Column(name="beverage_cost")
	private String beverageCost;

	@Column(name="beverage_created")
	private Date beverageCreated;

	@Column(name="beverage_name")
	private String beverageName;

	@Column(name="beverage_status")
	private String beverageStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="sold_date")
	private Date soldDate;

	@Column
	private  String beverageType;


	public void setBeverageType(String beverageType) {
		this.beverageType = beverageType;
	}

	public String getBeverageType() {
		return beverageType;
	}

	//bi-directional many-to-many association to Customer
	@ManyToMany
	@JoinTable(
		name="order"
		, joinColumns={
			@JoinColumn(name="beverage_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="customer_id")
			}
		)
	private Set<Customer> customers;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="beverage")
	private Set<Order> orders;

	public Beverage() {
	}

	public int getIdbeverage() {
		return this.idbeverage;
	}

	public void setIdbeverage(int idbeverage) {
		this.idbeverage = idbeverage;
	}

	public String getBeverageCost() {
		return this.beverageCost;
	}

	public void setBeverageCost(String beverageCost) {
		this.beverageCost = beverageCost;
	}

	public Date getBeverageCreated() {
		return this.beverageCreated;
	}

	public void setBeverageCreated(Date beverageCreated) {
		this.beverageCreated = beverageCreated;
	}

	public String getBeverageName() {
		return this.beverageName;
	}

	public void setBeverageName(String beverageName) {
		this.beverageName = beverageName;
	}

	public String getBeverageStatus() {
		return this.beverageStatus;
	}

	public void setBeverageStatus(String beverageStatus) {
		this.beverageStatus = beverageStatus;
	}

	public Date getSoldDate() {
		return this.soldDate;
	}

	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}

	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setBeverage(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setBeverage(null);

		return order;
	}

}