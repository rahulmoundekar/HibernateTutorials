package com.hibernate.apps;

import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

public class Trans {
	public static void main(String args[]) {

		Transaction tx = null;
		try {

			// Activate Hibernate Software
			Configuration cfg = new Configuration();
			cfg = cfg.configure("/hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session ses = factory.openSession();
			tx = ses.beginTransaction();

			Query q1 = ses
					.createQuery("update Account eb set eb.balance=7331 where eb.acno=:p1");
			q1.setInteger("p1", 1);
			// tx=ses.beginTransaction();
			int result = q1.executeUpdate();

			Query q2 = ses
					.createQuery("update Account eb set eb.balance='9221' where eb.acno=:p1");
			q2.setInteger("p1", 2);
			// tx=ses.beginTransaction();
			int result1 = q2.executeUpdate();
			if (result == 0 || result1 == 0) {
				System.out.println("Transaction rolledback");
			} else {
				tx.commit();
			}
			ses.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
