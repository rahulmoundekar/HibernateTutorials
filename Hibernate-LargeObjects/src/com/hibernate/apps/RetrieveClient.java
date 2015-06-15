package com.hibernate.apps;


import java.sql.Blob;
import java.sql.Clob;


import org.hibernate.*;
import org.hibernate.cfg.*;

public class RetrieveClient
{
    public static void main(String[] args)
    {
    //Activate Hibernate Software
    Configuration cfg=new Configuration();
    //make hibernate software locating and reading cfg file
    cfg=cfg.configure("/hibernate.cfg.xml");
    //create SessionFactory obj
    SessionFactory factory=cfg.buildSessionFactory();
    //create HB session obj
    Session ses=factory.openSession();
    Employeeprofile eb=(Employeeprofile)ses.load(Employeeprofile.class,new Integer(1001));
    Clob resume=eb.getEmpresume();
    Blob Photo=eb.getEmpphoto();
    
    String res1=LargeObjects.createFileFromClob(resume,"c:/store2/newresume.txt");
    String res2=LargeObjects.createFileFromBlob(Photo,"c:/store2/newpic.jpg");
    
        System.out.println(res1);
        System.out.println(res2);
        
        ses.close();
            
    }
   
}
