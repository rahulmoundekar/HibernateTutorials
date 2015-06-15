package com.hibernate.apps;

//SelectTest.java (ClentApp)
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class DeleteTest {

	public static void main(String[] args) {
		try {
			Session ses = new Configuration().configure().buildSessionFactory()
					.openSession();

			Transaction tx = ses.beginTransaction();
			Query q1 = ses.createQuery("from User");// deletes parent table
													// records
													// and associated records in
													// child table
			List l = q1.list();
			for (int i = 0; i < l.size(); ++i) {
				User u1 = (User) l.get(i);
				ses.delete(u1);
			}
			tx.commit();

			ses.close();
		}// try
		catch (Exception e) {
			e.printStackTrace();
		}
	}// main

}// class

