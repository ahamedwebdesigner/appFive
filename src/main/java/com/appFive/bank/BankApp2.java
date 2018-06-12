package com.appFive.bank;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appFive.Hr.util.HibernateUtil;
import com.appFive.bank.entities.User;

public class BankApp2 {

	// get the calculated values 
	public static void main(String[] args) {
	
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory("com/appFive/bank/conf/Bank_Hibernate.cfg.xml");
			Session session = sessionFactory.openSession();  
		
		Transaction tx = null;
		 try {
		     tx = session.beginTransaction();
		  
		      Criteria  criteria = session.createCriteria(User.class);
		        List<User> UserList = criteria.list();
		        for(User user : UserList){
		            
		           System.out.println("User Uppercase Name : " + user.getUpperfirstName());
		            System.out.println("User Full Name : " + user.getFullName());
		        	System.out.println("User getAge : " + user.getAge());
		        	System.out.println("User getMonthalySalary : " + user.getMonthalySalary());
		        }

				
				
		     tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     System.out.println("data is not selected");
		     e.printStackTrace(System.out);
		   
		 }
		 finally {
			 session.close();
		 }
	}
}
