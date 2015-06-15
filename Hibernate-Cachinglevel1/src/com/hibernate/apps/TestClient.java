package com.hibernate.apps;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class TestClient
{
    public static void main(String args[])
    {
    //Activate Hibernate Software
    Configuration cfg=new Configuration();
    //make hibernate software locating and reading cfg file
    cfg=cfg.configure("/hibernate.cfg.xml");
    //create SessionFactory obj
    SessionFactory factory=cfg.buildSessionFactory();
    //create HB session obj
    Session ses=factory.openSession();
    //write o-r mapping persistence logic
    //create object for HB POJO class with data
    Employee eb=(Employee)ses.load(Employee.class,1);
	System.out.println(eb.getEid()+" "+eb.getFname()+" "+eb.getLname()+" "+eb.getEmail());
	ses.evict(eb);
	ses.clear();
	//ses.close();
    eb=(Employee)ses.load(Employee.class,1);
	System.out.println(eb.getEid()+" "+eb.getFname()+" "+eb.getLname()+" "+eb.getEmail());
    ses.close();
    factory.close();
    
    }
} 
