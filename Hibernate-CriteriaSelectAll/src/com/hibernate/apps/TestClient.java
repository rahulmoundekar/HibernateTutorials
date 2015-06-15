package com.hibernate.apps;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class TestClient {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		// make hibernate software locating and reading cfg file
		cfg = cfg.configure("/hibernate.cfg.xml");
		// create SessionFactory obj
		SessionFactory factory = cfg.buildSessionFactory();
		// create HB session obj
		Session ses = factory.openSession();
		// create Criteria object
		Criteria ct = ses.createCriteria(Employee.class);
		// gives select * from query internally
		// execcute the presistence logic
		List l = ct.list();
		for (int i = 0; i < l.size(); i++) {
			Employee eb = (Employee) l.get(i);
			System.out.println(eb.getEid() + " " + eb.getFname() + " "
					+ eb.getLname() + " " + eb.getEmail());
			System.out.println("object class name is " + l.getClass());
		}

		ses.close();
	}
}
