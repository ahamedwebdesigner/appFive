package com.appFive.bank.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="USER")
public class User {

	
	
	@Id
	@TableGenerator(name="user_table_generator",
	table ="user_keys",
	pkColumnName="PK_NAME", 
			  valueColumnName = "next_val",
					  allocationSize=1,
	pkColumnValue="PK_VALUE"
	)
	@GeneratedValue (strategy=GenerationType.TABLE, generator="user_table_generator")

	@Column(name="USER_ID")
	private Long userId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="BIRTH_DATE")
	private Date birthDate;

	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Column(name="CREATED_DATE", 
				updatable=false,
				nullable=false)
	//@Basic == nullable = false
	private Date createdDate;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="SALARY")
	private String monthalySalary;
	
	
	

	/*************************Formula annotations***************************/
	
	// 1) case conversion
	
	@Formula(value = "upper(FIRST_NAME)")
    private String upperfirstName;
	public String getUpperfirstName() {
		return upperfirstName;
	}

	public void setUpperfirstName(String upperfirstName) {
		this.upperfirstName = upperfirstName;
	}
	
	// 2) concat
	@Formula(value = "concat(upper(FIRST_NAME), ' ', upper(LAST_NAME))")
	private String FullName;
	
	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}
	
	
	
	// 3) calculating age my using date of birth
	
	@Formula("lower(datediff(curdate(), birth_date)/365)")
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	@ElementCollection
	@CollectionTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	@AttributeOverrides(
			{
				@AttributeOverride(name="addressLine1", column=@Column(name="USER_ADDRESS_LINE_1")),
				@AttributeOverride(name="addressLine2", column=@Column(name="USER_ADDRESS_LINE_2"))
			})
	private List<Address> address = new ArrayList<Address>();

	
	
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	
	/*--------------------- #Formula annotations -----------------------------*/
	
	/*
	
	@ElementCollection
	@CollectionTable(name="USER_DEPARTMENTS", joinColumns=@JoinColumn(name="USER_ID"))
	@AttributeOverrides(
			{
				@AttributeOverride(name="departmentBranceh1", column=@Column(name="DEPT_BRANCH_1")),
				@AttributeOverride(name="departmentBranceh2", column=@Column(name="DEPT_BRANCH_2"))
			})
	private List<Departments> address = new ArrayList<Departments>();
	*/
	

	public String getMonthalySalary() {
		return monthalySalary;
	}

	public void setMonthalySalary(String monthalySalary) {
		this.monthalySalary = monthalySalary;
	}

	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}