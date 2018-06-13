package com.appFive.bank;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appFive.Hr.util.HibernateUtil;
import com.appFive.bank.entities.Address;
import com.appFive.bank.entities.User;

public class BankApp5 {

	public static void main(String[] args) {
	
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory("com/appFive/bank/conf/Bank_Hibernate.cfg.xml");
			Session session = sessionFactory.openSession();  
		
		Transaction tx = null;
		 try {
		     tx = session.beginTransaction();
		   
		     

		
				
				// inserting historic date
		     	Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, 1985);
				calendar.set(Calendar.MONTH, 6);
				calendar.set(Calendar.DATE, 19);
			
				Date birthdate = calendar.getTime();
				
				
				
				User user = new User();
				Address address1 = new Address();
				Address address2 = new Address();
				
				
				
				
				user.setBirthDate(birthdate);
				user.setCreatedBy("tiger scott");
				user.setCreatedDate(new Date());
				user.setEmailAddress("tigerUser@gmail.com");
				user.setFirstName("tiger ");
				user.setLastName("userOne");
				user.setLastUpdatedBy("Accounts Admin");
				user.setLastUpdatedDate(new Date());
				
				
				address1.setAddressLine1("address Line 1");
				address1.setAddressLine2("address Line 2");
				address1.setCity("Bangalore");
				address1.setState("KA");
				address1.setZipCode("12345");
	
				
				address2.setAddressLine1("Line 3");
				address2.setAddressLine2("LIne 3");
				address2.setCity("Hyderabad");
				address2.setState("AP");
				address2.setZipCode("6789");
		
				
				user.getAddress().add(address1);
				user.getAddress().add(address2);
				session.save(user);
				
		     tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     System.out.println("data is not saved");
		     e.printStackTrace(System.out);
		   
		 }
		 finally {
			 session.close();
		 }
		 
		 System.out.println("data is saved without any error");
	}
}
