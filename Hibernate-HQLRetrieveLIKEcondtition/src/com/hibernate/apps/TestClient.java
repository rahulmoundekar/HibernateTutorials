package com.hibernate.apps;

import java.util.*;
import org.hibernate.cfg.*;
import org.hibernate.*;

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
		// Query q1=ses.createQuery("select eb from Employee eb where eid>5");
		Query q1 = ses.createQuery(" from Employee eb where fname like 'r%'");
		List l = q1.list();// make Hibernate Software to execute HQL query
		// process the List DataSource
		for (int i = 0; i < l.size(); i++) {
			Employee eb = (Employee) l.get(i);
			System.out.println(eb.getEid() + " " + eb.getFname() + " "
					+ eb.getLname() + " " + eb.getEmail());
			System.out.println("object class name is " + l.getClass());
		}
		ses.close();
		/*
		 * Iterator it=q1.iterate(); q1.iterate(); while(it.hasNext()) {
		 * ps.Employee eb=(ps.Employee)it.next();
		 * System.out.println(eb.getEid()+
		 * " "+eb.getFname()+" "+eb.getLname()+" "+eb.getEmail()); }
		 */
	}
}
