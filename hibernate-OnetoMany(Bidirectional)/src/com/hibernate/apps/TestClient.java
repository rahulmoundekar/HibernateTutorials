package com.hibernate.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class TestClient {
	public static void main(String[] args) {
		try {
			Session ses = new Configuration().configure().buildSessionFactory()
					.openSession();

			Transaction tx = ses.beginTransaction();

			/*
			 * parent to child User u1 = new User(); u1.setUserId(101);
			 * u1.setFirstName("raja");
			 * 
			 * PhoneNumber ph1=new PhoneNumber();
			 * ph1.setNumberType("residence"); ph1.setPhone(63636363);
			 * ph1.setParent(u1);
			 * 
			 * PhoneNumber ph2=new PhoneNumber(); ph2.setNumberType("office");
			 * ph2.setPhone(61616161); ph2.setParent(u1);
			 * 
			 * Set s=new HashSet(); s.add(ph1); s.add(ph2);
			 * 
			 * u1.setPhones(s);
			 * 
			 * //To Insert record ses.save(u1);
			 */

			// child to parent

			PhoneNumber p1 = new PhoneNumber();
			p1.setNumberType("office");
			p1.setPhone(71717171);

			PhoneNumber p2 = new PhoneNumber();
			p2.setNumberType("res");
			p2.setPhone(81818181);

			PhoneNumber p3 = new PhoneNumber();
			p3.setNumberType("home");
			p3.setPhone(91919191);

			User u2 = new User();
			u2.setUserId(102);
			u2.setFirstName("ravi");

			p1.setParent(u2);
			p2.setParent(u2);
			p3.setParent(u2);

			Set s1 = new HashSet();
			s1.add(p1);
			s1.add(p2);
			s1.add(p3);
			u2.setPhones(s1);

			ses.save(p1);
			ses.save(p2);
			ses.save(p3);

			tx.commit();
			ses.close();
		}// try
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
