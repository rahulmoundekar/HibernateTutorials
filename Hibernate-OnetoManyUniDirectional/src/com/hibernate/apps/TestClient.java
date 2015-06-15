package com.hibernate.apps;

//TestClient (ClentApp)
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class TestClient {

	public static void main(String[] args) {
		try {
			Session ses = new Configuration().configure().buildSessionFactory()
					.openSession();

			Transaction tx = ses.beginTransaction();

			User u1 = new User();
			u1.setUserId(101);
			u1.setFirstName("raja1");

			PhoneNumber ph1 = new PhoneNumber();
			ph1.setNumberType("residence");
			ph1.setPhone(65538968);

			PhoneNumber ph2 = new PhoneNumber();
			ph2.setNumberType("office");
			ph2.setPhone(65538958);

			Set s = new HashSet();
			s.add(ph1);
			s.add(ph2);
			// setting PhoneNumber class objs to phones property of User obj
			u1.setPhones(s);

			// To Insert record
			ses.save(u1);

			User u2 = new User();
			u2.setUserId(102);
			u2.setFirstName("rajesh");

			PhoneNumber ph3 = new PhoneNumber();
			ph3.setNumberType("residence");
			ph3.setPhone(75538968);

			PhoneNumber ph4 = new PhoneNumber();
			ph4.setNumberType("office");
			ph4.setPhone(75538958);

			Set s1 = new HashSet();
			s1.add(ph3);
			s1.add(ph4);

			u2.setPhones(s1);

			// To Insert record
			ses.save(u2);

			tx.commit();
			ses.close();

		}// try
		catch (Exception e) {
			e.printStackTrace();
		}
	}// main

}// class

