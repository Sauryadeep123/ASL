package com.asl.dbentity;

public class LoginDetails
{
	private String _email;
	public String getemail()
	{
		return this._email;
	}
	public void setemail(String value)
	{
		this._email = value;
	}

	private String _password;
	public String getpassword()
	{
		return this._password;
	}
	public void setpassword(String value)
	{
		this._password = value;
	}

}