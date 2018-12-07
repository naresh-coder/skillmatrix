package com.enquero.prowessreef.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Permissions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "permissions", schema = "public")

public class Permissions implements java.io.Serializable {

	// Fields

	private Integer id;
	private String permissitionName;

	// Constructors

	/** default constructor */
	public Permissions() {
	}

	/** minimal constructor */
	public Permissions(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Permissions(Integer id, String permissitionName) {
		this.id = id;
		this.permissitionName = permissitionName;
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

	@Column(name = "permissition_name")

	public String getPermissitionName() {
		return this.permissitionName;
	}

	public void setPermissitionName(String permissitionName) {
		this.permissitionName = permissitionName;
	}

}