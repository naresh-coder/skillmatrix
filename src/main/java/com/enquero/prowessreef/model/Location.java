package com.enquero.prowessreef.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Location entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "location", schema = "public")

public class Location implements java.io.Serializable {

	// Fields

	private Integer locationId;
	private State state;
	private String locationName;
	private String pin;

	// Constructors

	/** default constructor */
	public Location() {
	}

	/** minimal constructor */
	public Location(Integer locationId) {
		this.locationId = locationId;
	}

	/** full constructor */
	public Location(Integer locationId, State state, String locationName, String pin) {
		this.locationId = locationId;
		this.state = state;
		this.locationName = locationName;
		this.pin = pin;
	}

	// Property accessors
	@Id

	@Column(name = "location_id", unique = true, nullable = false)

	public Integer getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Column(name = "location_name")

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Column(name = "pin")

	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

}