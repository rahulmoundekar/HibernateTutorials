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

		Query q1 = ses.getNamedQuery("test2");
		// set param values
		q1.setInteger(0, 10);
		q1.setInteger(1, 200);
		// execute HQL queries
		List l = q1.list();
		// process the results
		for (int i = 0; i < l.size(); i++) {
			// access each element of the list
			Object row[] = (Object[]) l.get(i);
			// process the elements of the list
			for (int k = 0; k < row.length; k++) {
				System.out.println(row[k].toString() + " "); // prints each
																// record
			}
			System.out.println();
		}

		Query q2 = ses.getNamedQuery("test3");
		// set param values
		q2.setInteger(0, 10);
		q2.setInteger(1, 200);
		// execute HQL queries
		List l1 = q2.list();
		// process the results
		for (int i = 0; i < l1.size(); i++) {
			// access each element of the list
			Object row[] = (Object[]) l1.get(i);
			// process the elements of the list
			for (int k = 0; k < row.length; k++) {
				System.out.println(row[k].toString() + " "); // prints each
																// record
			}
			System.out.println();
		}

		ses.close();

	}
}