package com.hibernate.apps;

import java.io.*;
import org.hibernate.cfg.*;
import org.hibernate.*;
import java.util.*;

public class Insert {
	public static void main(String args[]) {
		Transaction tx = null;
		Session ses = null;
		try {
			Configuration con = new Configuration().configure();
			SessionFactory sf = con.buildSessionFactory();
			ses = sf.openSession();
			tx = ses.beginTransaction();

			// employees information
			Employee e1 = new Employee();
			e1.setId(191);
			e1.setName(" Siva");
			e1.setCompany("company1");
			e1.setSalary(5000);
			e1.setDepartment(126);
			Employee e2 = new Employee();
			e2.setId(192);
			e2.setName("sam");
			e2.setCompany("company2");
			e2.setSalary(15000);
			e2.setDepartment(222);
			Employee e3 = new Employee();
			e3.setId(193);
			e3.setName("raju");
			e3.setCompany("company1");
			e3.setSalary(9000);
			e3.setDepartment(333);
			ses.save(e1);
			ses.save(e2);
			ses.save(e3);

			// customers information
			Customer c1 = new Customer();
			c1.setId(194);
			c1.setName("vasu");
			c1.setCompany("company2");
			c1.setAddress("Hyderabad");
			Customer c2 = new Customer();
			c2.setId(195);
			c2.setName("arun");
			c2.setCompany("company1");
			c2.setAddress("Vizag");
			ses.save(c1);
			ses.save(c2);

			// person information
			Person p1 = new Person();
			p1.setId(196);
			p1.setName("vamsi");
			p1.setCompany("company3");
			ses.save(p1);

			tx.commit();
			System.out.println("inserted successesfully");
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println(e);
		}

		ses.close();

	}
}