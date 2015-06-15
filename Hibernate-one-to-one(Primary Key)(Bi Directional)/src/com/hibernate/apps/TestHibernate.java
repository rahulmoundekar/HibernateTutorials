package com.hibernate.apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;
import entities.Customer;
import entities.Address;
import java.util.Iterator;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class TestHibernate {
	public static void main(String[] args) {
	    Session session = null;
	    Transaction ut = null;
	    try{
            
               //Activate Hibernate Software
    Configuration cfg=new Configuration();
    //make hibernate software locating and reading cfg file
    cfg=cfg.configure("/hibernate.cfg.xml");
    //create SessionFactory obj
    SessionFactory factory=cfg.buildSessionFactory();
    //create HB session obj
     session=factory.openSession();

            ut = session.getTransaction();
         
            ut.begin();
           // save customer 
	        Customer customer = new Customer();
		    customer.setCustomerId(1234565);
	        customer.setName("Surya");
	        customer.setEmailAddress("surya@gmail.com");
	        customer.setContactNo("91-932686876");
			
			
	        Address address = new Address();

	        address.setAddressLine1("xxx-street, near Surya Complex");
	        address.setCity("Pune");
		
	        address.setState("Maharashtra");
	        address.setPincode(11111);
	        
	       customer.setAddress(address);
	       address.setCustomer(customer);
	        session.save(customer);
			//session.save(address);  //This is optional here
		
		
	        
           //fetch all customers
            
            Query query = session.createQuery("from Customer customer");
            for(Iterator it=query.iterate();it.hasNext();){
            	Customer customer1 = (Customer) it.next();
            	Address address1 = customer1.getAddress();
                System.out.println("customer ID: " + customer1.getCustomerId());
                System.out.println("Name: " + customer1.getName());
                System.out.println("address: " + address1.getAddressLine1());
                System.out.println(address1.getAddressLine2());
                System.out.println(address1.getCity());
                System.out.println(address1.getState());
                System.out.println(address1.getPincode());
              }
	        
	        
	      // delete a customer
           /* Query query1 = session.createQuery("from Customer customer where customer.customerId = :cust").setLong("cust", 3);
            Customer customer2 = (Customer) query1.uniqueResult();
            session.delete(customer2);
            
            
            // delete address for a customer
            
            Query query2 = session.createQuery("from Customer customer where customer.customerId = :cust").setLong("cust", 1);
            Customer customer3 = (Customer) query2.uniqueResult();
            Address address2 = customer3.getAddress();
            customer3.setAddress(null);
            address2.setCustomer(null);
            session.delete(address2);*/
            
            

            
            
            ut.commit();

	        
	        System.out.println("Done");
	        
	    }catch(Exception e){
	    	e.printStackTrace();
	    	try{
	    		ut.rollback();
	    	}catch(Exception e1){
	    		System.out.println("Counldn't rollback ");
	    		e1.printStackTrace();
	    	}
	        System.out.println(e.getMessage());
	        e.printStackTrace();
	    }finally{
	    	session.close();
	    }
	  }

}
