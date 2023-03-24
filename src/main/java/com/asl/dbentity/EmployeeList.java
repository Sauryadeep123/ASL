package com.asl.dbentity;

public class EmployeeList
{
	private int serialNo;
	private String firstName;
	private String email;
	private String userId;
	private String password;
	public int getSerialNo() {
		return serialNo;
	}
	public EmployeeList() {
	
	}
	public EmployeeList(int serialNo, String firstName, String email, String userId, String password) {
		super();
		this.serialNo = serialNo;
		this.firstName = firstName;
		this.email = email;
		this.userId = userId;
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}