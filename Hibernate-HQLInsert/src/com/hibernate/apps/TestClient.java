package com.hibernate.apps;

//Before executing This program please create two tables like Employee and Employee4 in Database.
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

		Query q1 = ses
				.createQuery("insert into Employee1(eid,fname,lname,email)"
						+ "select eb.eid, eb.fname, eb.lname, eb.email from Employee eb");

		Transaction tx = ses.beginTransaction();
		int result = q1.executeUpdate();

		System.out.println("number of records affected" + result);
		tx.commit();
		ses.close();

	}
}
