package com.hibernate.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class TestClient {
	public static void main(String args[]) {
		// Activate Hibernate Software
		Configuration cfg = new Configuration();
		// make hibernate software locating and reading cfg file
		cfg = cfg.configure("/hibernate.cfg.xml");
		// create SessionFactory obj
		SessionFactory factory = cfg.buildSessionFactory();
		// create HB session obj
		Session ses = factory.openSession();

		Query q1 = ses.getNamedQuery("test1");
		q1.setInteger(0, 1);
		List l = q1.list();

		for (int i = 0; i < l.size(); i++) {
			Employee eb = (Employee) l.get(i);
			System.out.println(eb.getEid() + " " + eb.getFname() + " "
					+ eb.getLname() + " " + eb.getEmail());
			System.out.println("object class name is " + l.getClass());
		}
		ses.close();

	}
}