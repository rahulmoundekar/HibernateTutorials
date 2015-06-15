package com.hibernate.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class InsertTest {
	public static void main(String args[]) {
		Session ses = null;
		try {
			ses = new Configuration().configure().buildSessionFactory()
					.openSession();

			Transaction tx = ses.beginTransaction();

			Person p1 = new Person();
			JobType jt1 = new JobType();

			jt1.setJob("programmer");
			jt1.setSalary(12000);
			jt1.setDepartment(101);

			p1.setPname("raj");
			p1.setPjob(jt1);

			Person p2 = new Person();
			JobType jt2 = new JobType();
			jt2.setJob("clerk");
			jt2.setSalary(7000);
			jt2.setDepartment(102);

			p2.setPname("vasu");
			p2.setPjob(jt2);

			ses.save(p1);
			ses.save(p2);

			tx.commit();
			System.out.println("records  are inserted successfully");
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		ses.close();
	}// main
}// class