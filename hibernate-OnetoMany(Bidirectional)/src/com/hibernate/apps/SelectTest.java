package com.hibernate.apps;

//SelectTest.java (ClentApp)
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class SelectTest {

	public static void main(String[] args) {
		try {
			Configuration cf = new Configuration().configure();
			SessionFactory factory = cf.buildSessionFactory();
			Session ses = factory.openSession();

			// parent to child
			/*
			 * Query q1=ses.createQuery("from User"); List l=q1.list();
			 * 
			 * for(int i=0;i<l.size();++i) { User u1=(User)l.get(i);
			 * System.out.println
			 * ("parent:"+u1.getUserId()+"   "+u1.getFirstName());
			 * 
			 * Set s=u1.getPhones(); Iterator it=s.iterator();
			 * while(it.hasNext()) { PhoneNumber ph=(PhoneNumber)it.next();
			 * System
			 * .out.println("\t\t\t Child:"+ph.getPhone()+"  "+ph.getNumberType
			 * () +"   "+ph.getId()); }//while }//for
			 */

			System.out
					.println("--------------------------------------------------------------------------");

			// child to parent

			Query q2 = ses.createQuery("from PhoneNumber");
			List l2 = q2.list();

			for (int i = 0; i < l2.size(); ++i) {
				PhoneNumber ph = (PhoneNumber) l2.get(i);

				System.out.println("child :" + ph.getPhone() + "  "
						+ ph.getId() + "  " + ph.getNumberType());
				User u1 = ph.getParent();
				System.out.println("parent:" + u1.getUserId() + "   "
						+ u1.getFirstName() + "\n\n");
			}

			ses.close();
		}// try
		catch (Exception e) {
			e.printStackTrace();
		}
	}// main

}// class

