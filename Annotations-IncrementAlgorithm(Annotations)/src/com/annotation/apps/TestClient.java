package com.annotation.apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

public class TestClient {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Configuration cfg = new Configuration();

		cfg = cfg.configure("/hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session ses = factory.openSession();
		Student st1 = new Student();
		// modifying the record
		Transaction tx = ses.beginTransaction();
		st1.setAddr("Pulivendula");
		ses.save(st1);
		tx.commit();

		ses.close();
	}
}