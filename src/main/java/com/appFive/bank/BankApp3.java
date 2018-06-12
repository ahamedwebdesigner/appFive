package com.appFive.bank;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appFive.Hr.util.HibernateUtil;
import com.appFive.bank.entities.Bank;

public class BankApp3 {

	public static void main(String[] args) {
	
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory("com/appFive/bank/conf/Bank_Hibernate.cfg.xml");
			Session session = sessionFactory.openSession();  
		
		Transaction tx = null;
		 try {
		     tx = session.beginTransaction();
		 	Bank bank = new Bank();
			bank.setName("scott Trust");
			bank.setAddressLine1("33 Wall Street vagen");
			bank.setAddressLine2("Suite 233");
			bank.setCity("New York");
			bank.setState("NY");
			bank.setZipCode("12345");
			bank.setInternational(false);
			bank.setCreatedBy("Kevin");
			bank.setCreatedDate(new Date());
			bank.setLastUpdatedBy("Kevin");
			bank.setLastUpdatedDate(new Date());
			bank.getContacts().add("Joe");
			bank.getContacts().add("Mary");			
			bank.getContacts().add("syed");			
			bank.getContacts().add("ahemed");			
			session.save(bank);
			
		
				
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
