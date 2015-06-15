package com.hibernate.apps;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
		// write o-r mapping persistence logic
		// create object for HB POJO class with data
		Employee eb = new Employee();
		eb.setEid(142);
		eb.setFname("Rahul");
		eb.setLname("Moundekar");
		eb.setEmail("rahul@gmail.com");

		// make HB software insert record
		Transaction tx = ses.beginTransaction();
		ses.save(eb);
		tx.commit();
		System.out.println("Record inserted");

		ses.close();
		factory.close();

	}
}
