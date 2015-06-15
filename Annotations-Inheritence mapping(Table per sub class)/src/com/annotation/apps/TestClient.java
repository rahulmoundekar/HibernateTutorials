package com.annotation.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class TestClient {
	public static void main(String args[]) {
		Configuration conf = new Configuration();
		// conf.configure();
		Configuration cfg = new Configuration();

		cfg = cfg.configure("/hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session ses = factory.openSession();

		CreditCardPayment ob1 = new CreditCardPayment();
		ob1.setPaymentId(1);
		ob1.setCardType("Visa");
		ob1.setAmount(4000.0);

		ChequePayment ob2 = new ChequePayment();
		ob2.setPaymentId(2);
		ob2.setChequeType("order");
		ob2.setAmount(6000.0);

		Transaction tx = ses.beginTransaction();
		ses.save(ob1);
		ses.save(ob2);
		tx.commit();
		ses.close();
		factory.close();
	}
}
