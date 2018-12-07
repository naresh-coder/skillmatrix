package com.cofeeshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer orderId;

	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;

	@Column(name="total_amount")
	private BigDecimal totalAmount;


	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "order_ref")
	private  String orderRef;


	private String order_status;

	//bi-directional many-to-one association to Beverage
	@ManyToOne
	@JoinColumn(name="beverage_id")
	private Beverage beverage;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Order() {
	}



	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_status() {
		return order_status;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Beverage getBeverage() {
		return this.beverage;
	}

	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

}