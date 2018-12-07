package com.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SkillMatrix entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "skill_matrix", schema = "public")

public class SkillMatrix implements java.io.Serializable {

	// Fields

	private Integer skillMatrixId;
	private Employee employee;
	private SkillName skillName;
	private SkillCategory skillCategory;
	private DesignationMatrix designationMatrix;
	private Kpi kpi;
	private String noOfYears;
	private String isCertified;
	private String nameOfInstitute;
	private String score;

	// Constructors

	/** default constructor */
	public SkillMatrix() {
	}

	/** minimal constructor */
	public SkillMatrix(Integer skillMatrixId) {
		this.skillMatrixId = skillMatrixId;
	}

	/** full constructor */
	public SkillMatrix(Integer skillMatrixId, Employee employee, SkillName skillName, SkillCategory skillCategory,
			DesignationMatrix designationMatrix, Kpi kpi, String noOfYears, String isCertified, String nameOfInstitute,
			String score) {
		this.skillMatrixId = skillMatrixId;
		this.employee = employee;
		this.skillName = skillName;
		this.skillCategory = skillCategory;
		this.designationMatrix = designationMatrix;
		this.kpi = kpi;
		this.noOfYears = noOfYears;
		this.isCertified = isCertified;
		this.nameOfInstitute = nameOfInstitute;
		this.score = score;
	}

	// Property accessors
	@Id

	@Column(name = "skill_matrix_id", unique = true, nullable = false)

	public Integer getSkillMatrixId() {
		return this.skillMatrixId;
	}

	public void setSkillMatrixId(Integer skillMatrixId) {
		this.skillMatrixId = skillMatrixId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skill_id")

	public SkillName getSkillName() {
		return this.skillName;
	}

	public void setSkillName(SkillName skillName) {
		this.skillName = skillName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skill_category_id")

	public SkillCategory getSkillCategory() {
		return this.skillCategory;
	}

	public void setSkillCategory(SkillCategory skillCategory) {
		this.skillCategory = skillCategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "designation_id")

	public DesignationMatrix getDesignationMatrix() {
		return this.designationMatrix;
	}

	public void setDesignationMatrix(DesignationMatrix designationMatrix) {
		this.designationMatrix = designationMatrix;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kpi_id")

	public Kpi getKpi() {
		return this.kpi;
	}

	public void setKpi(Kpi kpi) {
		this.kpi = kpi;
	}

	@Column(name = "no_of_years")

	public String getNoOfYears() {
		return this.noOfYears;
	}

	public void setNoOfYears(String noOfYears) {
		this.noOfYears = noOfYears;
	}

	@Column(name = "isCertified")

	public String getIsCertified() {
		return this.isCertified;
	}

	public void setIsCertified(String isCertified) {
		this.isCertified = isCertified;
	}

	@Column(name = "name_of_institute")

	public String getNameOfInstitute() {
		return this.nameOfInstitute;
	}

	public void setNameOfInstitute(String nameOfInstitute) {
		this.nameOfInstitute = nameOfInstitute;
	}

	@Column(name = "score")

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}