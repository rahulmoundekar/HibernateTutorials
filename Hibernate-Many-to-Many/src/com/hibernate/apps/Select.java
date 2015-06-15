package com.hibernate.apps;

import java.util.Iterator;
import java.util.Set;
import java.io.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;
import org.hibernate.HibernateException;

public class Select {
	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration();
			// make hibernate software locating and reading cfg file
			cfg = cfg.configure("/hibernate.cfg.xml");
			// create SessionFactory obj
			SessionFactory factory = cfg.buildSessionFactory();
			// create HB session obj
			Session ses = factory.openSession();
			System.out.println("All programmers");
			Query query = ses.createQuery("from Programmers");
			Iterator i1 = query.iterate();
			while (i1.hasNext()) {
				Programmers p1 = (Programmers) i1.next();
				System.out.println(p1.getPid() + " " + p1.getPname() + " "
						+ p1.getSalary());
				Set projects = p1.getProjects();
				Iterator i2 = projects.iterator();

				while (i2.hasNext()) {
					Projects t1 = (Projects) i2.next();
					System.out.println(t1.getProdid() + " " + t1.getProname());
				}
			}
			System.out.println("all projects");
			Query query1 = ses.createQuery("from Projects");
			i1 = query1.iterate();

			while (i1.hasNext()) {
				Projects t1 = (Projects) i1.next();
				System.out.println(t1.getProdid() + " " + t1.getProname());
				Set programmers = t1.getProgrammers();
				Iterator i2 = programmers.iterator();
				while (i2.hasNext()) {
					Programmers p1 = (Programmers) i2.next();
					System.out.println(p1.getPid() + " " + p1.getSalary());

				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}
}
