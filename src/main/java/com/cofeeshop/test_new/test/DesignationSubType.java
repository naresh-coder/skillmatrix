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
 * DesignationSubType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "designation_sub_type", schema = "public")

public class DesignationSubType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String subTypeName;
	private Set<DesignationMatrix> designationMatrixesForDisgnationSubId = new HashSet<DesignationMatrix>(0);
	private Set<DesignationMatrix> designationMatrixesForDisgnationTypeId = new HashSet<DesignationMatrix>(0);

	// Constructors

	/** default constructor */
	public DesignationSubType() {
	}

	/** minimal constructor */
	public DesignationSubType(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public DesignationSubType(Integer id, String subTypeName,
			Set<DesignationMatrix> designationMatrixesForDisgnationSubId,
			Set<DesignationMatrix> designationMatrixesForDisgnationTypeId) {
		this.id = id;
		this.subTypeName = subTypeName;
		this.designationMatrixesForDisgnationSubId = designationMatrixesForDisgnationSubId;
		this.designationMatrixesForDisgnationTypeId = designationMatrixesForDisgnationTypeId;
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

	@Column(name = "sub_type_name")

	public String getSubTypeName() {
		return this.subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "designationSubTypeByDisgnationSubId")

	public Set<DesignationMatrix> getDesignationMatrixesForDisgnationSubId() {
		return this.designationMatrixesForDisgnationSubId;
	}

	public void setDesignationMatrixesForDisgnationSubId(Set<DesignationMatrix> designationMatrixesForDisgnationSubId) {
		this.designationMatrixesForDisgnationSubId = designationMatrixesForDisgnationSubId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "designationSubTypeByDisgnationTypeId")

	public Set<DesignationMatrix> getDesignationMatrixesForDisgnationTypeId() {
		return this.designationMatrixesForDisgnationTypeId;
	}

	public void setDesignationMatrixesForDisgnationTypeId(
			Set<DesignationMatrix> designationMatrixesForDisgnationTypeId) {
		this.designationMatrixesForDisgnationTypeId = designationMatrixesForDisgnationTypeId;
	}

}