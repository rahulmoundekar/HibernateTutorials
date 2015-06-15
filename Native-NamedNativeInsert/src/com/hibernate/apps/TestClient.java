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

		Query q1 = ses.getNamedQuery("test1");
		q1.setInteger(0, 32);
		q1.setString(1, "Tamanna");
		q1.setString(2, "Bhatia");
		q1.setString(3, "t@b.com");
		Transaction tx = ses.beginTransaction();
		int result = q1.executeUpdate();

		System.out.println("number of records affected" + result);
		tx.commit();
		ses.close();

	}
}
