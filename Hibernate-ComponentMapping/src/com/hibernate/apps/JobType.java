package com.hibernate.apps;




public class JobType
{
    private String job;
    private double salary;
    private int department;



    public void setJob(String s)
    {
        job = s;
    }

    public String getJob()
    {
        return job;
    }

    public void setSalary(double d)
    {
        salary = d;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setDepartment(int i)
    {
        department = i;
    }

    public int getDepartment()
    {
        return department;
    }

}