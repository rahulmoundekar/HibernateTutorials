package com.hibernate.apps;


public class Employee  implements java.io.Serializable {


     private int eid;
     private String fname;
     private String lname;
     private String email;

    public Employee() {
    }

	
    public Employee(int eid) {
        this.eid = eid;
    }
    public Employee(int eid, String fname, String lname, String email) {
       this.eid = eid;
       this.fname = fname;
       this.lname = lname;
       this.email = email;
    }
   
    public long getEid() {
        return this.eid;
    }
    
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}


