package com.test;

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
 * Kpi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "kpi", schema = "public")

public class Kpi implements java.io.Serializable {

	// Fields

	private Integer id;
	private String employeeTarget;
	private String recheadTarget;
	private Set<SkillMatrix> skillMatrixes = new HashSet<SkillMatrix>(0);

	// Constructors

	/** default constructor */
	public Kpi() {
	}

	/** minimal constructor */
	public Kpi(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Kpi(Integer id, String employeeTarget, String recheadTarget, Set<SkillMatrix> skillMatrixes) {
		this.id = id;
		this.employeeTarget = employeeTarget;
		this.recheadTarget = recheadTarget;
		this.skillMatrixes = skillMatrixes;
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

	@Column(name = "employee_target")

	public String getEmployeeTarget() {
		return this.employeeTarget;
	}

	public void setEmployeeTarget(String employeeTarget) {
		this.employeeTarget = employeeTarget;
	}

	@Column(name = "rechead_target")

	public String getRecheadTarget() {
		return this.recheadTarget;
	}

	public void setRecheadTarget(String recheadTarget) {
		this.recheadTarget = recheadTarget;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "kpi")

	public Set<SkillMatrix> getSkillMatrixes() {
		return this.skillMatrixes;
	}

	public void setSkillMatrixes(Set<SkillMatrix> skillMatrixes) {
		this.skillMatrixes = skillMatrixes;
	}

}