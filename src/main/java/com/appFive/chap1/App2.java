package com.appFive.chap1;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.appFive.model.Employee;

public class App2 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Employee.class);
		
		/* Building SessionFactory */
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(new StandardServiceRegistryBuilder(
						).applySettings(configuration.getProperties()).build());
		Session session = sessionFactory.openSession();
		
		Employee emp = new Employee();
		emp.setName("syed");
		emp.setRole("Java developer");
		emp.setInsertTime(new Date());
		
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		
		session.close();

	}

}
