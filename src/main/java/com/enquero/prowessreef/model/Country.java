package com.enquero.prowessreef.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Country entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "country", schema = "public")

public class Country implements java.io.Serializable {

	// Fields

	private Integer countryId;
	private String contryName;
	private Set<State> states = new HashSet<State>(0);

	// Constructors

	/** default constructor */
	public Country() {
	}

	/** minimal constructor */
	public Country(Integer countryId) {
		this.countryId = countryId;
	}

	/** full constructor */
	public Country(Integer countryId, String contryName, Set<State> states) {
		this.countryId = countryId;
		this.contryName = contryName;
		this.states = states;
	}

	// Property accessors
	@Id

	@Column(name = "country_id", unique = true, nullable = false)

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Column(name = "contry_name")

	public String getContryName() {
		return this.contryName;
	}

	public void setContryName(String contryName) {
		this.contryName = contryName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")

	public Set<State> getStates() {
		return this.states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

}