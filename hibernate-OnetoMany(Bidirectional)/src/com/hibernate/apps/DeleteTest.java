package com.hibernate.apps;

//DeleteTest.java (ClentApp)
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class DeleteTest {

	public static void main(String[] args) throws Exception {
		Session ses = new Configuration().configure().buildSessionFactory()
				.openSession();

		/*
		 * //parent to child Transaction tx=ses.beginTransaction(); User u1=new
		 * User(); u1.setUserId(101);
		 * 
		 * PhoneNumber p1=new PhoneNumber(); p1.setPhone(63636363);
		 * p1.setParent(u1);
		 * 
		 * PhoneNumber p2=new PhoneNumber(); p2.setPhone(61616161);
		 * p2.setParent(u1);
		 * 
		 * 
		 * Set s=new HashSet(); s.add(p1); s.add(p2);
		 * 
		 * u1.setPhones(s);
		 * 
		 * ses.delete(u1);
		 * 
		 * tx.commit();
		 */

		// child to parent deletion
		Transaction tx = ses.beginTransaction();
		User u1 = new User();
		u1.setUserId(102);

		PhoneNumber p1 = new PhoneNumber();
		p1.setPhone(81818181);
		p1.setParent(u1);

		PhoneNumber p2 = new PhoneNumber();
		p2.setPhone(91919191);
		p2.setParent(u1);

		PhoneNumber p3 = new PhoneNumber();
		p3.setPhone(71717171);
		p3.setParent(u1);

		Set s = new HashSet();
		s.add(p1);
		s.add(p2);
		s.add(p3);

		u1.setPhones(s);

		ses.delete(p1);
		ses.delete(p2);
		ses.delete(p3);

		tx.commit();
		ses.close();
	}// main
}// class

