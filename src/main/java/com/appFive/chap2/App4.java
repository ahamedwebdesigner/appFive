package com.appFive.chap2;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.appFive.model.Staff;

public class App4 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate-xml-maping.cfg.xml");
		
		/* Building SessionFactory */
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(new StandardServiceRegistryBuilder(
						).applySettings(configuration.getProperties()).build());
		Session session = sessionFactory.openSession();
		
		Staff emp = new Staff();
		emp.setName("syed");
		emp.setRole("CEO");
		emp.setDepartment("Finance");
		emp.setInsertTime(new Date());
		
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		
		session.close();

	}

}
