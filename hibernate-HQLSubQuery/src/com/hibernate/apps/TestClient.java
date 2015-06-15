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
 
  Query q1=ses.createQuery("from Employee eb where eb.eid=(select max(eb.eid) from Employee eb)");
		List l=q1.list();
		for(int i=0;i<l.size();i++)
		{
			Employee eb=(Employee)l.get(i);
			System.out.println(eb.getEid()+" "+eb.getFname()+" "+eb.getLname()+" "+eb.getEmail());
		}

}
}    
