package com.hibernate.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class TestClient {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Product p=new Product();
		p = (Product) session.get(Product.class, 1);

		Transaction tx = session.beginTransaction();

		p.setPrice(1445);

		session.save(p);
		System.out.println("Object saved successfully.....!!");
		tx.commit();
		System.out.println("record modified for" + p.getV() + "times");
		session.close();
		factory.close();
	}

}