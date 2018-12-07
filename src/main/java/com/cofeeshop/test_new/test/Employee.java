package com.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "employee", schema = "public")

public class Employee implements java.io.Serializable {

	// Fields

	private Integer employeeId;
	private String name;
	private Integer emailId;
	private Integer phoneNumber;
	private String flag;
	private String gender;
	private String createdBy;
	private Date creationDate;
	private Date updatedBy;
	private Date updatedDate;
	private Set<SkillMatrix> skillMatrixes = new HashSet<SkillMatrix>(0);
	private Set<Address> addresses = new HashSet<Address>(0);

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/** full constructor */
	public Employee(Integer employeeId, String name, Integer emailId, Integer phoneNumber, String flag, String gender,
			String createdBy, Date creationDate, Date updatedBy, Date updatedDate, Set<SkillMatrix> skillMatrixes,
			Set<Address> addresses) {
		this.employeeId = employeeId;
		this.name = name;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.flag = flag;
		this.gender = gender;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.skillMatrixes = skillMatrixes;
		this.addresses = addresses;
	}

	// Property accessors
	@Id

	@Column(name = "employee_id", unique = true, nullable = false)

	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email_id")

	public Integer getEmailId() {
		return this.emailId;
	}

	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}

	@Column(name = "phone_number")

	public Integer getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "flag")

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name = "gender")

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "created_by")

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "creation_date", length = 13)

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_by", length = 13)

	public Date getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_date", length = 13)

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")

	public Set<SkillMatrix> getSkillMatrixes() {
		return this.skillMatrixes;
	}

	public void setSkillMatrixes(Set<SkillMatrix> skillMatrixes) {
		this.skillMatrixes = skillMatrixes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")

	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}