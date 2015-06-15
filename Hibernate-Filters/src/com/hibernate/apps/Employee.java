package com.hibernate.apps;

//EmpBean.java
public class Employee
{
	int eid;
	String fname,lname,email;

	public void setEid(int eid)
	{
		this.eid=eid;
	}

	public int getEid()
	{
		return eid;
	}

	public void setFname(String fname)
	{
		this.fname=fname;
	}

	public String getFname()
	{
		return fname;
	}

	public void setLname(String lname)
	{
		this.lname=lname;
	}
	public String getLname()
	{
		return lname;
	}

	public void setEmail(String email)
	{
		this.email=email;
	}

	public String getEmail()
	{
		return email;
	}

}