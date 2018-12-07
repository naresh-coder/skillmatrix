package com.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roles", schema = "public")

public class Roles implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private Integer permissonId;

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** minimal constructor */
	public Roles(Integer roleId) {
		this.roleId = roleId;
	}

	/** full constructor */
	public Roles(Integer roleId, String roleName, Integer permissonId) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.permissonId = permissonId;
	}

	// Property accessors
	@Id

	@Column(name = "role_id", unique = true, nullable = false)

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name")

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "permisson_Id")

	public Integer getPermissonId() {
		return this.permissonId;
	}

	public void setPermissonId(Integer permissonId) {
		this.permissonId = permissonId;
	}

}