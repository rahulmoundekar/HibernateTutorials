package flush;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class TestClient {
	public static void main(String args[]) {
		// Activate Hibernate Software
		Configuration cfg = new Configuration();
		// make hibernate software locating and reading cfg file
		cfg = cfg.configure("/hibernate.cfg.xml");
		// create SessionFactory obj
		SessionFactory factory = cfg.buildSessionFactory();
		// create HB session obj
		Session ses = factory.openSession();
		// write o-r mapping persistence logic
		// create object for HB POJO class with data
		Employee eb = (Employee) ses.get(Employee.class, 1);
		System.out.println(eb.getEid() + " " + eb.getFname() + " "
				+ eb.getLname() + " " + eb.getEmail());

		Employee eb1 = (Employee) ses.get(Employee.class, 2);
		System.out.println(eb1.getEid() + " " + eb1.getFname() + " "
				+ eb1.getLname() + " " + eb1.getEmail());

		eb.setEmail("gir");
		System.out.println(eb.getEid() + " " + eb.getFname() + " "
				+ eb.getLname() + " " + eb.getEmail());
		eb1.setEmail("gir2");
		System.out.println(eb1.getEid() + " " + eb1.getFname() + " "
				+ eb1.getLname() + " " + eb1.getEmail());

		ses.flush();
		ses.close();
		factory.close();

	}
}
