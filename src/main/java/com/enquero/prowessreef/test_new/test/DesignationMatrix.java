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
 * DesignationMatrix entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "designation_matrix", schema = "public")

public class DesignationMatrix implements java.io.Serializable {

	// Fields

	private Integer id;
	private DesignationSubType designationSubTypeByDisgnationTypeId;
	private DesignationSubType designationSubTypeByDisgnationSubId;
	private Set<SkillMatrix> skillMatrixes = new HashSet<SkillMatrix>(0);

	// Constructors

	/** default constructor */
	public DesignationMatrix() {
	}

	/** minimal constructor */
	public DesignationMatrix(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public DesignationMatrix(Integer id, DesignationSubType designationSubTypeByDisgnationTypeId,
			DesignationSubType designationSubTypeByDisgnationSubId, Set<SkillMatrix> skillMatrixes) {
		this.id = id;
		this.designationSubTypeByDisgnationTypeId = designationSubTypeByDisgnationTypeId;
		this.designationSubTypeByDisgnationSubId = designationSubTypeByDisgnationSubId;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "disgnation_type_id")

	public DesignationSubType getDesignationSubTypeByDisgnationTypeId() {
		return this.designationSubTypeByDisgnationTypeId;
	}

	public void setDesignationSubTypeByDisgnationTypeId(DesignationSubType designationSubTypeByDisgnationTypeId) {
		this.designationSubTypeByDisgnationTypeId = designationSubTypeByDisgnationTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "disgnation_sub_id")

	public DesignationSubType getDesignationSubTypeByDisgnationSubId() {
		return this.designationSubTypeByDisgnationSubId;
	}

	public void setDesignationSubTypeByDisgnationSubId(DesignationSubType designationSubTypeByDisgnationSubId) {
		this.designationSubTypeByDisgnationSubId = designationSubTypeByDisgnationSubId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "designationMatrix")

	public Set<SkillMatrix> getSkillMatrixes() {
		return this.skillMatrixes;
	}

	public void setSkillMatrixes(Set<SkillMatrix> skillMatrixes) {
		this.skillMatrixes = skillMatrixes;
	}

}