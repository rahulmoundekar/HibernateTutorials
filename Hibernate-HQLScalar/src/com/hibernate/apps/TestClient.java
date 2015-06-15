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
 
 /*Query q1=ses.createQuery("select eb.fname,eb.lname from Employee eb where eb.eid>=?");
   //set param values
   q1.setInteger(0,10);
   //execute HQL queries
  List l=q1.list();
  //process the results
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
  }*/
 Query q1=ses.createQuery("select eb.fname,eb.lname from Employee eb where eb.eid>=?");
   //set param values
   q1.setInteger(0,1);
   //execute HQL queries
  Iterator itr=q1.iterate();
  //process the results
  while(itr.hasNext())
  {
    //access each element of the list
    Object row[]=(Object[])itr.next();
    //process the elements of the list
    for(int k=0;k<row.length;k++)
    {
        System.out.println(row[k].toString()+" "); //prints each record
    }
    System.out.println();
  }
  }
}    
