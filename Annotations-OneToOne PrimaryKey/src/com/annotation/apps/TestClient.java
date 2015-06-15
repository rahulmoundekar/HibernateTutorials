package com.annotation.apps;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.cfg.*;
import org.hibernate.*;

public class TestClient {
	public static void main(String args[]) {
		Configuration cfg = new Configuration();
		// make hibernate software locating and reading cfg file
		cfg = cfg.configure("/hibernate.cfg.xml");
		// create SessionFactory obj
		SessionFactory factory = cfg.buildSessionFactory();
		// create HB session obj
		Session ses = factory.openSession();

		Student st = new Student();
		st.setFirstName("raja");
		st.setLastName("rao");
		st.setAddress("hyderabad");

		Library lib = new Library();
		lib.setDoj(new Date());
		lib.setStudent(st);
		st.setLibrary(lib);

		Transaction tx = ses.beginTransaction();
		ses.save(st);
		tx.commit();

		ses.close();
	}
}