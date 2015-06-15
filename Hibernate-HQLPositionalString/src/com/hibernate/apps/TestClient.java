package com.hibernate.apps;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import java.util.*;
public class TestClient
{
public static void main(String args[])
{
   Configuration cfg=new Configuration();
    //make hibernate software locating and reading cfg file
    cfg=cfg.configure("/hibernate.cfg.xml");
    //create SessionFactory obj
    SessionFactory factory=cfg.buildSessionFactory();
    //create HB session obj
    Session ses=factory.openSession();
   Query q1=ses.createQuery("select eb from Employee eb where eid>? and lname like ?");
      //setting values to parameters
   int a=1;
   String b="%m";
   Integer a1=new Integer(a); //Object type casting
   String b1=new String(b);
   q1.setInteger(0,a1);
   q1.setString(1,b1);
   List l=q1.list();//make Hibernate Software to execute HQL query
    //process the List DataSource 
    for(int i=0;i<l.size();i++)
    {
       Employee eb=(Employee)l.get(i);
       System.out.println(eb.getEid()+" "+eb.getFname()+" "+eb.getLname()+" "+eb.getEmail()); 
    }
       System.out.println("object class name is "+l.getClass());   

      ses.close();  
  }
}
