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
 * SkillCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "skill_category", schema = "public")

public class SkillCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String skillCategoryName;
	private Set<SkillMatrix> skillMatrixes = new HashSet<SkillMatrix>(0);

	// Constructors

	/** default constructor */
	public SkillCategory() {
	}

	/** minimal constructor */
	public SkillCategory(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SkillCategory(Integer id, String skillCategoryName, Set<SkillMatrix> skillMatrixes) {
		this.id = id;
		this.skillCategoryName = skillCategoryName;
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

	@Column(name = "skill_category_name")

	public String getSkillCategoryName() {
		return this.skillCategoryName;
	}

	public void setSkillCategoryName(String skillCategoryName) {
		this.skillCategoryName = skillCategoryName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "skillCategory")

	public Set<SkillMatrix> getSkillMatrixes() {
		return this.skillMatrixes;
	}

	public void setSkillMatrixes(Set<SkillMatrix> skillMatrixes) {
		this.skillMatrixes = skillMatrixes;
	}

}