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

		Customer c1 = new Customer();
		c1.setCustomerid(701);
		c1.setCustomername("raja1");

		Customer c2 = new Customer();
		c2.setCustomerid(702);
		c2.setCustomername("raja2");

		// adding child objects to collection
		Set s = new HashSet();
		s.add(c1);
		s.add(c2);

		// adding collection to parent

		Vendor vp = new Vendor();
		vp.setVendorid(1001);
		vp.setVendorname("vendor1");
		vp.setChildren(s);
		Transaction tx = ses.beginTransaction();
		ses.save(vp);
		tx.commit();
		ses.close();
	}
}