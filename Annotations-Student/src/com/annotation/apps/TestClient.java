package com.annotation.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class TestClient {
	public static void main(String args[]) {
		Configuration cfg = new Configuration();

		cfg = cfg.configure("/hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session ses = factory.openSession();
		Transaction tx = ses.beginTransaction();
		Student st = new Student();
		st.setSno(new Integer(107));
		st.setSname("BSBR");
		st.setAddr("Mysore");
		ses.save(st);

		tx.commit();

		Query q1 = ses.createQuery("from Student st");
		List l1 = q1.list();
		for (int i = 0; i < l1.size(); i++) {
			Student s1 = (Student) l1.get(i);
			{
				System.out.println(s1.getSno() + " " + s1.getSname() + " "
						+ s1.getAddr());
			}

		}
	}
}