package com.appFive.chap1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.appFive.model.Employee;

public class App3 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Employee.class);
		
		/* Building SessionFactory */
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(new StandardServiceRegistryBuilder(
						).applySettings(configuration.getProperties()).build());
		Session session = sessionFactory.openSession();
		
	
		List studentsList = new ArrayList();	
		
		session.beginTransaction();
		
		//All recards
		// studentsList = session.createQuery("FROM Employee").list();
		 
		 
		//find by ID
		 Employee e1 = (Employee) session.load(Employee.class, 3);
		 e1.setRole("UI/UX developer");
		 
		 //update
		 session.update(e1);
		 
		 //delet object
		 // session.delete(e1);
		
		 System.out.println("==============================================");
		 System.out.println(e1);
		session.getTransaction().commit();
		
		session.close();

	}

}
