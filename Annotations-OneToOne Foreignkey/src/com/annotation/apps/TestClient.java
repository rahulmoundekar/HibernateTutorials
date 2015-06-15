package com.annotation.apps;

import org.hibernate.Session;
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

		Student st = new Student();
		st.setStudentId(101);
		st.setStudentName("Bhagvat");

		Address a = new Address();
		a.setAddressId(1);
		a.setPlace("karvenagar");

		st.setAddress(a);
		Transaction tx = ses.beginTransaction();
		ses.save(st);
		tx.commit();

		ses.close();
	}
}