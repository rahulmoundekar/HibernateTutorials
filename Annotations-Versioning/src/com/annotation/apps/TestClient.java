package com.annotation.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class TestClient {
	public static void main(String args[]) {
		Configuration cfg = new Configuration();

		cfg = cfg.configure("/hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session ses = factory.openSession();
		Student st1 = (Student) ses.get(Student.class, 1);
		// modifying the record
		Transaction tx = ses.beginTransaction();
		st1.setAddr("pune");
		ses.save(st1);
		tx.commit();

		System.out.println("record modified for" + st1.getVer() + "times");
		ses.close();
	}
}