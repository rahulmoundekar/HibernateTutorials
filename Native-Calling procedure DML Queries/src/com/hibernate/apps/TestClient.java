package com.hibernate.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.sql.*;

public class TestClient {

	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration();
			cfg = cfg.configure("/hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session ses = factory.openSession();
			Transaction tx = ses.beginTransaction();
			Connection con = ses.connection();
			
			// crate callable Statement obj
			CallableStatement cs = con.prepareCall("{call fir_emp(?,?,?)}");
			// register OUT parameter wiht JDBC Types
			
			cs.registerOutParameter(3, Types.INTEGER);
			// set values to IN paramters
			cs.setInt(1, 1);
			cs.setInt(2, 3);
			// call PL/SQL procedure
			cs.execute();
			// gather result from OUT params
			System.out.println("nmmber of employees are fired=" + cs.getInt(3));
			tx.commit();
			cs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
