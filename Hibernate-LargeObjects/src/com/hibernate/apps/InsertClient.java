package com.hibernate.apps;


import java.sql.Blob;
import java.sql.Clob;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class InsertClient 
{
public static void main(String args[])
{
    try
    {
   //Activate Hibernate Software
    Configuration cfg=new Configuration();
    //make hibernate software locating and reading cfg file
    cfg=cfg.configure("/hibernate.cfg.xml");
    //create SessionFactory obj
    SessionFactory factory=cfg.buildSessionFactory();
    //create HB session obj
    Session ses=factory.openSession();
    
    String fileContent=LargeObjects.readFileAsString("C:/store/readme.txt");
    Clob resume=Hibernate.createClob(fileContent);
    
    byte fileByte[]=LargeObjects.getBytesArrayFromFile("c:/store/sunset.jpg");
    Blob photo=Hibernate.createBlob(fileByte);
    
    Employeeprofile eb=new Employeeprofile();
    eb.setEmpid(1001);
    eb.setEname("Rahul");
    eb.setEmpresume(resume);
    eb.setEmpphoto(photo);
    
    Transaction tx=ses.beginTransaction();
    ses.save(eb);
    tx.commit();
    System.out.println("successfully inserted");
    
    ses.close();
    
}
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
}
