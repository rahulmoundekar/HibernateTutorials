package com.hibernate.apps;

//SelectTest.java (ClentApp)
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class SelectTest {

public static void main(String[] args)
{
	try
	{
			Session ses=new Configuration().configure().buildSessionFactory().openSession();

          
			Query q1=ses.createQuery("from User");//gives parent  table records
			                                                                          //and associated child table records

			List l=q1.list();

			for(int i=0;i<l.size();++i)
     		{
				User u1=(User)l.get(i);
				System.out.println("parent:"+u1.getUserId()+"   "+u1.getFirstName());

				Set s=u1.getPhones();
				Iterator it=s.iterator();
				while(it.hasNext())
				{
					 PhoneNumber ph=(PhoneNumber)it.next();
					 System.out.println("\t\t\t Child:"+ph.getPhone()+"  "+ph.getNumberType()
						                                                      +"   "+ph.getId());
				}//while 

			}

		


		


			/*Query q1=ses.createQuery("from PhoneNumber");
			                                                       // gives only child table records
			l=q1.list();

			for(int i=0;i<l.size();++i)
     		{
				PhoneNumber ph=(PhoneNumber)l.get(i);
				System.out.println(ph.getNumberType()+"  "+ph.getPhone()+
					                                "  "+ph.getId());

			}*/


		   ses.close();
   		}//try
		catch(Exception e)
	     { 
		e.printStackTrace();
		}
  }//main

}//class

