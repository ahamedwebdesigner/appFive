package com.appFive.bank;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appFive.Hr.util.HibernateUtil;
import com.appFive.bank.entities.User;

public class BankApp1 {

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
				user.setBirthDate( calendar.getTime());
				user.setCreatedBy("Ramana Rao");
				user.setCreatedDate(new Date());
				user.setEmailAddress("Rao@gmail.com");
				//user.setEmailAddress(null);
				user.setFirstName("Karan");
				user.setLastName("sing");
				user.setLastUpdatedBy("Ramana");
				user.setLastUpdatedDate(new Date());
				
				//System.out.println(user.getAge());
				session.save(user);
				
			/*	//refress the data
				session.refresh(user);
				System.out.println(user.getAge());*/
				
				
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
	}
}
