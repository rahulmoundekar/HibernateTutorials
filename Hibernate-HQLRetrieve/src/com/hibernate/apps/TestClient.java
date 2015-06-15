package com.hibernate.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
public class TestClient
{
public static void main(String args[])
{

    Configuration cfg=new Configuration();
    cfg=cfg.configure("/hibernate.cfg.xml");
    //create SessionFactory obj
    SessionFactory factory=cfg.buildSessionFactory();
    //create HB session obj
    Session ses=factory.openSession();
    Query q1=ses.createQuery("select eb from Employee eb");
   // Query q1=ses.createQuery("select eb from Employee eb where eid>5");
   List l=q1.list();//make Hibernate Software to execute HQL query
    //process the List DataSource 
    for(int i=0;i<l.size();i++)
    {
       Employee eb=(Employee)l.get(i);
       System.out.println(eb.getEid()+" "+eb.getFname()+" "+eb.getLname()+" "+eb.getEmail()); 
       System.out.println("object class name is "+l.getClass());   
    }
    
    /*Iterator it=q1.iterate();
    q1.iterate();
    while(it.hasNext())
    {
         Employee eb=(Employee)it.next();
         System.out.println(eb.getEid()+" "+eb.getFname()+" "+eb.getLname()+" "+eb.getEmail()); 
    }  */
	ses.close();
	factory.close();
}
}
