package com.hibernate.apps;

import org.hibernate.cfg.*;
import org.hibernate.*;
import java.util.*;

public class TestClient {
	public static void main(String args[]) {
		Session ses = null;
		try {
			Configuration con = new Configuration().configure();
			SessionFactory sf = con.buildSessionFactory();
			ses = sf.openSession();

			/*
			 * // enable fileter on Hibernate Ses obj org.hibernate.Filter
			 * f1=ses.enableFilter("myfilter");
			 * 
			 * // set filter parameter values f1.setParameter("myid1",new
			 * Integer(100)); f1.setParameter("myid2",new Integer(400));
			 * 
			 * 
			 * // HQL Query (executes with filter cond) Query
			 * q1=ses.createQuery("from Employee"); List l=q1.list(); //excutes
			 * HQL query with condition
			 * 
			 * for(int i=0;i<l.size();++i) { Employee e=(Employee)l.get(i);
			 * System.out.println(e.getEid()+"  "+e.getFname()+
			 * "  "+e.getLname()+"  "+e.getEmail()); }
			 * 
			 * // HQL Query (executes with fileter cond) Query
			 * q2=ses.createQuery
			 * ("select eb.fname,eb.lname from Employee as eb"); Iterator
			 * it=q2.iterate(); while(it.hasNext()) { Object
			 * row[]=(Object[])it.next(); for(int k=0;k<row.length;++k) {
			 * System.out.print(row[k].toString()+"   "); }
			 * System.out.println(); }//while
			 * 
			 * // disabling filter on ses object ses.disableFilter("myfilter");
			 * 
			 * //HQL Query (executes with out filter condition) Query
			 * q3=ses.createQuery("from Employee"); List l1=q3.list();
			 * 
			 * for(int i=0;i<l1.size();++i) { Employee e=(Employee)l1.get(i);
			 * System
			 * .out.println(e.getEid()+"  "+e.getFname()+"  "+e.getLname()+
			 * "  "+e.getEmail()); } }
			 */

			// Native SQL query

			org.hibernate.Filter f1 = ses.enableFilter("myfilter");
			f1.setParameter("myid1", new Integer(100));
			f1.setParameter("myid2", new Integer(400));

			SQLQuery query = ses.createSQLQuery("Select  * from Employee");

			query.addEntity(Employee.class);

			List l = query.list();

			for (int i = 0; i < l.size(); ++i) {
				Employee e = (Employee) l.get(i);
				System.out.println(e.getEid() + "  " + e.getFname() + "  "
						+ e.getLname() + "  " + e.getEmail());
			}
		}

		// On Criteria API
		/*
		 * Criteria ct=ses.createCriteria(Employee.class);
		 * 
		 * org.hibernate.Filter f1=ses.enableFilter("myfilter");
		 * f1.setParameter("myid1",new Integer(100));
		 * f1.setParameter("myid2",new Integer(400));
		 * 
		 * 
		 * List l=ct.list();
		 * 
		 * for(int i=0;i<l.size();++i) { Employee e1=(Employee)l.get(i);
		 * System.out
		 * .println(e1.getEid()+"  "+e1.getFname()+"  "+e1.getLname()+" "
		 * +e1.getEmail()); }
		 * 
		 * }
		 */
		catch (HibernateException e) {
			e.printStackTrace();
		}
		ses.close();
	}
}