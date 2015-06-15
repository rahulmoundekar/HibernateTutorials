package com.hibernate.apps;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
public class  TestClient
{

   
    public static void main(String[] args) 
    {
       Configuration cfg=new Configuration();
    //make hibernate software locating and reading cfg file
    cfg=cfg.configure("/hibernate.cfg.xml");
    //create SessionFactory obj
    SessionFactory factory=cfg.buildSessionFactory();
    //create HB session obj
    Session ses=factory.openSession();
   
    Query q=ses.getNamedQuery("test1");
    //selecting parameter values
    q.setString("p1","c%");
	
    List l=q.list();
    //call PL/SQL procedure from Databases software
    /* for(int i=0;i<l.size();i++)
    {
    Object row[]=(Object[])l.get(i);
    	    //process the elements of the list
    	    for(int k=0;k<row.length;k++)
    	    {
    	        System.out.println(row[k]+" "); //prints each record
    	    }
       
    }*/
	 for(int i=0;i<l.size();i++)
  {
    //access each element of the list
    Object row[]=(Object[])l.get(i);
    //process the elements of the list
    for(int k=0;k<row.length;k++)
    {
        System.out.println(row[k].toString()+" "); //prints each record
    }
    System.out.println();
  }
 
    }
}
