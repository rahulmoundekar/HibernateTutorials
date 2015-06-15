package com.hibernate.apps;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    Employee eb=new Employee();
    //eb.setEid(101); //If we remove this comment also it will accept increment algorithm at won't take at the time 101 value
    eb.setFname("rakesh");
    eb.setLname("sharma");
    eb.setEmail("123422");
   
    //make HB software insert record
    Transaction tx=ses.beginTransaction();
    ses.save(eb);
    tx.commit();
    //close Stream objects
    ses.close();
    factory.close();
    }
}
