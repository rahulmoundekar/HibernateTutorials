

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
public class TestClient
{
    public static void main(String args[])
    {
    //Activate Hibernate Software
    Configuration cfg=new Configuration();
	cfg.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
	cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/revisehibernate");
	cfg.setProperty("hibernate.connection.username","root");
	cfg.setProperty("hibernate.connection.password","root");
	cfg.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
	cfg.addFile("employee.hbm.xml");
    //create SessionFactory obj
    SessionFactory factory=cfg.buildSessionFactory();
    //create HB session obj
    Session ses=factory.openSession();
    //write o-r mapping persistence logic
    //create object for HB POJO class with data
    Employee eb=(Employee)ses.get(Employee.class,1);
	System.out.println(eb.getEid()+" "+eb.getFname()+" "+eb.getLname()+" "+eb.getEmail());
	try
	{
	Thread.sleep(2000);
	}
	catch(InterruptedException ie)
	{
	System.err.println("hello");
	}
	ses.refresh(eb);
	System.out.println(eb.getEid()+" "+eb.getFname()+" "+eb.getLname()+" "+eb.getEmail());
	
    ses.close();
    factory.close();
    
    }
}
