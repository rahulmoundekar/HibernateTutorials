package com.hibernate.apps;

import java.io.*;
import org.hibernate.cfg.*;
import org.hibernate.*;
import java.util.*;
import org.hibernate.HibernateException;

public class Select {
	public static void main(String args[]) {
		try {
			Configuration cfg = new Configuration();
			// make hibernate software locating and reading cfg file
			cfg = cfg.configure("/hibernate.cfg.xml");
			// create SessionFactory obj
			SessionFactory factory = cfg.buildSessionFactory();
			// create HB session obj
			Session ses = factory.openSession();

			Query query = ses.createQuery("from  Speaker ");
			Iterator i1 = query.iterate();
			while (i1.hasNext()) {
				Speaker s1 = (Speaker) i1.next();
				System.out.println(s1.getSid() + " " + s1.getSname());
				List sessions = s1.getSessions();
				Iterator i2 = sessions.iterator();

				while (i2.hasNext()) {
					Sessions t1 = (Sessions) i2.next();
					System.out.println(t1.getSesid() + " " + t1.getSesname());
				}
				List phonenumbers = s1.getPhonenumbers();
				Iterator i3 = phonenumbers.iterator();

				while (i3.hasNext()) {
					String ph = (String) i3.next();
					System.out.println(ph);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
