package com.hibernate.apps;

import java.io.*;
import org.hibernate.cfg.*;
import org.hibernate.*;
import java.util.*;

public class Select {
	public static void main(String args[]) {

		try {
			Session ses = new Configuration().configure().buildSessionFactory()
					.openSession();

			// employees information
			System.out.println("all employees");

			Query query = ses.createQuery("from Employee");
			Iterator i1 = query.iterate();
			while (i1.hasNext()) {
				Employee e1 = (Employee) i1.next();
				System.out.println(e1.getId() + " " + e1.getName() + " "
						+ e1.getCompany() + " " + e1.getSalary() + " "
						+ e1.getDepartment() + " ");

			}

			// customers information
			System.out.println("all customers");

			query = ses.createQuery("from Customer");
			i1 = query.iterate();
			while (i1.hasNext()) {
				Customer c1 = (Customer) i1.next();
				System.out.println(c1.getId() + " " + c1.getName() + " "
						+ c1.getCompany() + " " + c1.getAddress());

			}

			// persons information
			System.out.println("all persons");

			query = ses.createQuery("from Person");
			i1 = query.iterate();
			while (i1.hasNext()) {
				Person p1 = (Person) i1.next();
				System.out.println(p1.getId() + " " + p1.getName() + " "
						+ p1.getCompany() + " ");

			}

		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}
}