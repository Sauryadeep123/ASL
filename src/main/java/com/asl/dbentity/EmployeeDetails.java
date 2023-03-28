package com.asl.dbentity;

import java.sql.Date;

public class EmployeeDetails
{
	
	private int serialNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String city;
	private java.sql.Date dob;
	private String userid;
	private String photo;
	private String resume;
	private String password;
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDob() {
		return dob.toString();
	}
	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeDetails(int serialNo, String firstName, String middleName, String lastName, String email,
			String city, Date dob, String userid, String photo, String resume, String password) {
		super();
		this.serialNo = serialNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.dob = dob;
		this.userid = userid;
		this.photo = photo;
		this.resume = resume;
		this.password = password;
	}
	public EmployeeDetails() {
		
	}
	
}