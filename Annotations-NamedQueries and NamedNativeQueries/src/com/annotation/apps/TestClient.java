package com.annotation.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class TestClient {
	public static void main(String args[]) {
		Configuration cfg = new Configuration();

		cfg = cfg.configure("/hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session ses = factory.openSession();

		Query q1 = ses.getNamedQuery("p1");

		List l1 = q1.list();
		for (int i = 0; i < l1.size(); i++) {
			Student s1 = (Student) l1.get(i);
			{
				System.out.println(s1.getSno() + " " + s1.getSname() + " "
						+ s1.getAddr());
			}
		}

		Query q2 = ses.getNamedQuery("p2");
		List l2 = q2.list();
		for (int i = 0; i < l2.size(); i++) {
			Student s2 = (Student) l2.get(i);
			{
				System.out.println(s2.getSno() + " " + s2.getSname() + " "
						+ s2.getAddr());
			}
		}

		/*
		 * Query q2=ses.getNamedQuery("0"); q2.setString("0","S%");
		 * 
		 * 
		 * List l2=q2.list(); for(int i=0;i<l2.size();i++) { Student
		 * s1=(Student)l2.get(i); {
		 * System.out.println(s1.getSno()+" "+s1.getSname()+" "+s1.getAddr()); }
		 * 
		 * }
		 */

	}
}