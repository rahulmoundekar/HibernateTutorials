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
			Speaker s1 = new Speaker();
				s1.setSid(101);
				s1.setSname("raja");
			Speaker s2 = new Speaker();
				s2.setSid(102);
				s2.setSname("ravi");

			ses.save(s1);
			ses.save(s2);

			Sessions t1 = new Sessions();
				t1.setSesid(1);
				t1.setSesname("session1");
			Sessions t2 = new Sessions();
				t2.setSesid(2);
				t2.setSesname("session2");
			Sessions t3 = new Sessions();
				t3.setSesid(3);
				t3.setSesname("session3");
			Sessions t4 = new Sessions();
				t4.setSesid(4);
				t4.setSesname("session4");
			Sessions t5 = new Sessions();
				t5.setSesid(5);
				t5.setSesname("session5");

			ses.save(t1);
			ses.save(t2);
			ses.save(t3);
			ses.save(t4);
			ses.save(t5);

			s1.getSessions().add(t1);
			s1.getSessions().add(t2);
			s1.getSessions().add(t3);
			s2.getSessions().add(t4);
			s2.getSessions().add(t5);

			s1.getPhonenumbers().add("111111");
			s1.getPhonenumbers().add("2222");
			s2.getPhonenumbers().add("33333");
			s2.getPhonenumbers().add("444444");
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
 * create table speaker3(sid number(5) primary key, sname varchar2(10))
 * 
 * create table speaker_session3(sesid number(5) primary key, ses_name
 * varchar2(20), speaker_id number(5) references speaker3(sid))
 * 
 * 
 * create table speaker_phonenumbers3(phone varchar2(10), speaker_id number(5)
 * references speaker3(sid))
 */

/*
 * OUTPUT select * from SPEAKER_SESSION3;
 * 
 * SESID SES_NAME SPEAKER_ID ------ -------------------- ---------- 1 session1
 * 101 2 session2 101 3 session3 101 4 session4 102 5 session5 102
 * 
 * 
 * select * from SPEAKER3;
 * 
 * SID SNAME ------ ---------- 101 raja 102 ravi
 * 
 * 
 * SQL> select * from SPEAKER_PHONENUMBERS3;
 * 
 * PHONE SPEAKER_ID ---------- ---------- 111111 101 2222 101 33333 102 444444
 * 102
 */