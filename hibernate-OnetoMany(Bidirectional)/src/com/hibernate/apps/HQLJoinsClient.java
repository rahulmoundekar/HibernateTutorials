package com.hibernate.apps;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class HQLJoinsClient {

	public static void main(String[] args) {
		try {
			Configuration conf = new Configuration().configure();
			SessionFactory factory = conf.buildSessionFactory();
			Session ses = factory.openSession();

			/*
			 * // parent-child String
			 * hql="select ub from User as ub  	inner join    ub.phones ";
			 * //select ub from User as ub left join ub.phones "; //select ub
			 * from User as ub right join ub.phones "; Query
			 * q=ses.createQuery(hql); List l=q.list();
			 * 
			 * for(int i=0;i<l.size();++i) { User u1=(User)l.get(i);
			 * System.out.println("\n\n\nParent---->");
			 * System.out.print("user id:"+u1.getUserId());
			 * System.out.println("FirstName "+u1.getFirstName());
			 * 
			 * 
			 * Set s=u1.getPhones();
			 * 
			 * if(s!=null) { Iterator it=s.iterator(); while(it.hasNext()) {
			 * PhoneNumber p1=(PhoneNumber) it.next();
			 * System.out.println("\nchild---->");
			 * System.out.print("Number Type"+p1.getNumberType());
			 * System.out.print("Phone Number"+p1.getPhone());
			 * System.out.println("User id"+p1.getId()); }//inner while }//if
			 * }//outer for
			 */

			// child to parent

			String hql = "select ph from PhoneNumber as ph  inner join  fetch ph.parent ";
			// select ph from PhoneNumber as ph right join fetch ph.parent ";
			// select ph from PhoneNumber as ph left join fetch ph.parent ";

			Query q = ses.createQuery(hql);

			List l = q.list();
			for (int i = 0; i < l.size(); ++i) {
				PhoneNumber ph = (PhoneNumber) l.get(i);
				System.out.println("phone number type" + ph.getNumberType());
				System.out.println(" Phone " + ph.getPhone());
				System.out.println(" userid " + ph.getId());

				User u1 = ph.getParent();
				if (u1 != null) {
					System.out.println("user name" + u1.getFirstName());
					System.out.println("user id " + u1.getUserId());
				}
			}

			ses.close();
		}// try
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
