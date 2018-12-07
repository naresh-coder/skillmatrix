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
 * SkillName entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "skill_name", schema = "public")

public class SkillName implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<SkillMatrix> skillMatrixes = new HashSet<SkillMatrix>(0);

	// Constructors

	/** default constructor */
	public SkillName() {
	}

	/** minimal constructor */
	public SkillName(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SkillName(Integer id, String name, Set<SkillMatrix> skillMatrixes) {
		this.id = id;
		this.name = name;
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

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "skillName")

	public Set<SkillMatrix> getSkillMatrixes() {
		return this.skillMatrixes;
	}

	public void setSkillMatrixes(Set<SkillMatrix> skillMatrixes) {
		this.skillMatrixes = skillMatrixes;
	}

}