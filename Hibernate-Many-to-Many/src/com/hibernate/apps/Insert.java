package com.hibernate.apps;

import org.hibernate.cfg.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;

public class Insert {
	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration();
			// make hibernate software locating and reading cfg file
			cfg = cfg.configure("/hibernate.cfg.xml");
			// create SessionFactory obj
			SessionFactory factory = cfg.buildSessionFactory();
			// create HB session obj
			Session ses = factory.openSession();
			Transaction tx = ses.beginTransaction();

			// programmers inormation
			Programmers p1 = new Programmers(111, "raja", 25000);
			Programmers p2 = new Programmers(222, "siva", 25000);
			Programmers p3 = new Programmers(333, "veera", 25000);
			Programmers p4 = new Programmers(444, "kumar", 25000);

			ses.save(p1);
			ses.save(p2);
			ses.save(p3);
			ses.save(p4);

			// projects infofmation

			Projects t1 = new Projects(1001, "project1");
			Projects t2 = new Projects(1002, "project2");
			Projects t3 = new Projects(1003, "project3");

			ses.save(t1);
			ses.save(t2);
			ses.save(t3);

			// mapping projects to programmers

			p1.getProjects().add(t1);
			p1.getProjects().add(t3);

			p2.getProjects().add(t1);
			p2.getProjects().add(t2);
			p2.getProjects().add(t3);

			p3.getProjects().add(t2);

			p4.getProjects().add(t1);
			p4.getProjects().add(t2);

			tx.commit();

			System.out.println("inserted sucessfully");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e);
		}
	}
}

/*
 * Tables
 * 
 * create table programmers(pid number(5) primary key, pname varchar2(10),
 * salary number(8,2))
 * 
 * create table projects(prodid number(10) primary key,proname varchar2(20));
 * 
 * create table programmers_projects(programmer_id number(5) references
 * programmers(pid),project_id number(5) references projects(prodid), primary
 * key(programmer_id,project_id))
 */

