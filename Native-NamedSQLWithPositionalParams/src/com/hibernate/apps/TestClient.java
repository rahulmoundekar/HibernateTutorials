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

		SQLQuery q1 = ses
				.createSQLQuery("select * from Employee where eid>=? and fname like ?");

		// set param valies
		q1.setInteger(0, 1);
		q1.setString(1, "%m");

		q1.addEntity(Employee.class);
		// execute native SQL Query
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