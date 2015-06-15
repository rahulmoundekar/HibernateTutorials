package com.hibernate.apps;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
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
 
   Query q1=ses.createQuery("select count(*) from Employee eb");
   
  List l=q1.list();
  
  Long l1=(Long)l.get(0);
  long cnt=l1.longValue();
   
       System.out.println("Cont of records"+cnt); 
      ses.close();     
}
}    
