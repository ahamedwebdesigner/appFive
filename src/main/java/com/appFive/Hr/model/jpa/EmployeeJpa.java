package com.appFive.Hr.model.jpa;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="EMPLOYEE")


public class EmployeeJpa {
	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="cell_phone")
	private String cellphone;

	@OneToOne(mappedBy="employee", cascade=CascadeType.ALL)
	private EmployeeDetailJpa employeeDetail;

	/*v1*/
		@Temporal(TemporalType.DATE)
	    private Date insertDate;
		 @Temporal(TemporalType.TIME)
	    private Date insertTime;
		  @Temporal(TemporalType.TIMESTAMP)
	    private Date modifiedDateTime;
	/*v1*/
	    
	    
	    
	public EmployeeJpa() {

	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(java.util.Date now) {
		this.insertDate = now;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public EmployeeJpa(String firstname, String lastname, java.sql.Date birthdate,
			String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthdate;
		this.cellphone = phone;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public EmployeeDetailJpa getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetailJpa employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	
	
	
}
