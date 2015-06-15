package com.hibernate.apps;

import com.hibernate.*;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class SelectTest {

	public static void main(String args[]) {
		try {
			Session ses = new Configuration().configure().buildSessionFactory()
					.openSession();

			Query q1 = ses.createQuery("from Person");
			List l = q1.list(); // excute the HQL

			for (int i = 0; i < l.size(); i++) {
				Person p = (Person) l.get(i);
				JobType jt = p.getPjob();

				System.out.println(p.getPid() + "  " + p.getPname() + "  "
						+ jt.getJob() + "  " + jt.getSalary() + "  "
						+ jt.getDepartment());
			}

			ses.close();

		}// try
		catch (HibernateException he) {
			he.printStackTrace();
		}

	}// main
}// class
