package com.enquero.prowessreef.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "address", schema = "public")

public class Address implements java.io.Serializable {

	// Fields

	private Integer addressId;
	private Employee employee;
	private String addressName;
	private String landMark;
	private String city;
	private String state;
	private String country;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(Integer addressId) {
		this.addressId = addressId;
	}

	/** full constructor */
	public Address(Integer addressId, Employee employee, String addressName, String landMark, String city, String state,
			String country) {
		this.addressId = addressId;
		this.employee = employee;
		this.addressName = addressName;
		this.landMark = landMark;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	// Property accessors
	@Id

	@Column(name = "address_id", unique = true, nullable = false)

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "address_name")

	public String getAddressName() {
		return this.addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	@Column(name = "land_mark")

	public String getLandMark() {
		return this.landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	@Column(name = "city")

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state")

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "country")

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}