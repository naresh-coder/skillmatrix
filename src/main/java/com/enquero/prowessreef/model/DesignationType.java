package com.enquero.prowessreef.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DesignationType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "designation_type", schema = "public")

public class DesignationType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String designationName;

	// Constructors

	/** default constructor */
	public DesignationType() {
	}

	/** minimal constructor */
	public DesignationType(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public DesignationType(Integer id, String designationName) {
		this.id = id;
		this.designationName = designationName;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "designation_name")

	public String getDesignationName() {
		return this.designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

}