package com.hibernate.apps;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class TestClient {
	public static void main(String args[]) {
		Configuration cfg = new Configuration();
		// make hibernate software locating and reading cfg file
		cfg = cfg.configure("/hibernate.cfg.xml");
		// create SessionFactory obj
		SessionFactory factory = cfg.buildSessionFactory();
		// create HB session obj
		Session ses = factory.openSession();
		// Query q1=ses.createQuery("select eb from Employee eb");
		Query q1 = ses
				.createQuery("select eb from Employee eb where eid>:P1 and email like:P2");
		// setting values to parameters
		int a = 1;
		String b = "r%";
		Integer a1 = new Integer(a); // Object type casting
		String b1 = new String(b);

		q1.setInteger("P1", a1);
		q1.setString("P2", b1);

		List l = q1.list();// make Hibernate Software to execute HQL query
		// process the List DataSource
		for (int i = 0; i < l.size(); i++) {
			Employee eb = (Employee) l.get(i);
			System.out.println(eb.getEid() + " " + eb.getFname() + " "
					+ eb.getLname() + " " + eb.getEmail());
		}
		System.out.println("object class name is " + l.getClass());
		ses.close();
	}
}
