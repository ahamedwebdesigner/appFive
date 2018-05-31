package com.appFive.Hr.model;

import java.util.Date;

public class Employee {
	private Long employeeId;
	private String firstname;
	private String lastname;
	private java.sql.Date birthDate;
	private String cellphone;
	private EmployeeDetail employeeDetail;

	/*v1*/
	    private Date insertDate;
	    private Date insertTime;
	    private Date modifiedDateTime;
	/*v1*/
	    
	    
	    
	public Employee() {

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

	public Employee(String firstname, String lastname, java.sql.Date birthdate,
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

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	
	
	
}
