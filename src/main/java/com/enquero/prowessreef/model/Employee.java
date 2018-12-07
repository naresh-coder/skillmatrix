package com.enquero.prowessreef.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Employee {


  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
  @SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq", allocationSize = 1)
  @Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
  private Integer employeeId;
  @JsonProperty
  private String name;
  @JsonProperty
  private Integer emailId;
  @JsonProperty
  private Integer phoneNumber;
  @JsonProperty
  private String flag;
  @JsonProperty
  private String gender;
  @JsonProperty
  private String createdBy;
  @JsonProperty
  private Date creationDate;
  @JsonProperty
  private Date updatedBy;
  @JsonProperty
  private Date updatedDate;
  @JsonProperty
//  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "")
//  private Set<SkillMatrix> skillMatrixes = new HashSet<SkillMatrix>(0);

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getEmailId() {
    return emailId;
  }

  public void setEmailId(Integer emailId) {
    this.emailId = emailId;
  }

  public Integer getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(Integer phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Date getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Date updatedBy) {
    this.updatedBy = updatedBy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(getEmployeeId(), employee.getEmployeeId()) &&
        Objects.equals(getName(), employee.getName()) &&
        Objects.equals(getEmailId(), employee.getEmailId()) &&
        Objects.equals(getPhoneNumber(), employee.getPhoneNumber()) &&
        Objects.equals(getFlag(), employee.getFlag()) &&
        Objects.equals(getGender(), employee.getGender()) &&
        Objects.equals(getCreatedBy(), employee.getCreatedBy()) &&
        Objects.equals(getCreationDate(), employee.getCreationDate()) &&
        Objects.equals(getUpdatedBy(), employee.getUpdatedBy()) &&
        Objects.equals(getUpdatedDate(), employee.getUpdatedDate());
//        Objects.equals(getSkillMatrixes(), employee.getSkillMatrixes()) &&
//        Objects.equals(getAddresses(), employee.getAddresses());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getEmployeeId(), getName(), getEmailId(), getPhoneNumber(), getFlag(), getGender(), getCreatedBy(), getCreationDate(), getUpdatedBy(), getUpdatedDate() /*,getSkillMatrixes()*//*, getAddresses()*/);
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

//  public Set<SkillMatrix> getSkillMatrixes() {
//    return skillMatrixes;
//  }
//
//  public void setSkillMatrixes(Set<SkillMatrix> skillMatrixes) {
//    this.skillMatrixes = skillMatrixes;
//  }

//  public Set<Address> getAddresses() {
//    return addresses;
//  }
//
//  public void setAddresses(Set<Address> addresses) {
//    this.addresses = addresses;
//  }
//
//  @JsonProperty
//  private Set<Address> addresses = new HashSet<Address>(0);

  }
