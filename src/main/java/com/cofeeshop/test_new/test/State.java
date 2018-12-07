package com.test;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * State entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "state", schema = "public")

public class State implements java.io.Serializable {

	// Fields

	private Integer stateId;
	private Country country;
	private String stateName;
	private Set<Location> locations = new HashSet<Location>(0);

	// Constructors

	/** default constructor */
	public State() {
	}

	/** minimal constructor */
	public State(Integer stateId) {
		this.stateId = stateId;
	}

	/** full constructor */
	public State(Integer stateId, Country country, String stateName, Set<Location> locations) {
		this.stateId = stateId;
		this.country = country;
		this.stateName = stateName;
		this.locations = locations;
	}

	// Property accessors
	@Id

	@Column(name = "state_id", unique = true, nullable = false)

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contry_id")

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "state_name")

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "state")

	public Set<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

}