package com.annotation.apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class TestClient {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Configuration cfg = new Configuration();

		cfg = cfg.configure("/hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();

		Department department = new Department();
		department.setDepartmentName("Sales");
		session.save(department);

		Employee emp1 = new Employee("Nina", "Mayers", "111");
		Employee emp2 = new Employee("Tony", "Almeida", "222");

		emp1.setDepartment(department);
		emp2.setDepartment(department);

		session.save(emp1);
		session.save(emp2);

		session.getTransaction().commit();
		session.close();
	}
}