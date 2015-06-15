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
 
   Query q1=ses.createQuery("select count(*),max(eid),min(eid),sum(eid),avg(eid) from Employee ");
   
  List l=q1.list();
  
  Object result[]=(Object[])l.get(0);
  
  Long res1=(Long)result[0];
  long count=res1.longValue();
  
  Long res2=(Long)result[1];
  long max=res2.longValue();
  
   Long res3=(Long)result[2];
  long min=res3.longValue();
 
  Long res4=(Long)result[3];
  long sum=res4.longValue();
  
  Double res5=(Double)result[4];
  double avg=res4.doubleValue();
  
 System.out.println("Number of records"+count); 
 System.out.println("Maximum of  records"+max);
 System.out.println("Minimum of  records"+min);
 System.out.println("Sum of  records"+sum);
  System.out.println(" Average of  records"+avg);
       
  ses.close();     
}
}    
