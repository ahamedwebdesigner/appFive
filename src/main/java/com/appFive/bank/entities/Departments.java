package com.appFive.bank.entities;

import javax.persistence.Column;

public class Departments {

	@Column(name="DEPT_BRANCH_1")
	private String departmentBranceh1;

	@Column(name="DEPT_BRANCH_2")
	private String departmentBranceh2;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIP_CODE")
	private String zipCode;

	
	
	public Departments() {
		super();
	}

	public String getDepartmentBranceh1() {
		return departmentBranceh1;
	}

	public void setDepartmentBranceh1(String departmentBranceh1) {
		this.departmentBranceh1 = departmentBranceh1;
	}

	public String getDepartmentBranceh2() {
		return departmentBranceh2;
	}

	public void setDepartmentBranceh2(String departmentBranceh2) {
		this.departmentBranceh2 = departmentBranceh2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Departments [departmentBranceh1=" + departmentBranceh1 + ", departmentBranceh2=" + departmentBranceh2
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	
	
}
