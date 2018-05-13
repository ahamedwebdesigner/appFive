package com.appFive.chap1;


import java.util.Date;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.appFive.model.Employee;

public class App1 {

	public static void main(String[] args) {
	
/*		
		Properties mysql = 	new Properties() {
			{
				put("hibernate.connection.username", "hybernateAdmin");
				put("hibernate.connection.password", "hybernateAdmin");
				put("hibernate.connection.driver_class",
						"com.mysql.jdbc.Driver");
				put("hibernate.connection.url",
						"jdbc:mysql://localhost:3306/hibernatetest");
				
				put("dialect",
						"org.hibernate.dialect.MySQLDialect");
				put("show_sql","true");
				put("hibernate.current_session_context_class","thread");
			}
		};
			*/
		
		
		// 1) configurations
		Properties mysqlConf = 	new Properties();
		mysqlConf.put("hibernate.connection.username", "AppFiveAdmin");
		mysqlConf.put("hibernate.connection.password", "AppFiveAdmin123");
		mysqlConf.	put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
		mysqlConf.put("hibernate.connection.url","jdbc:mysql://localhost:3306/AppFive");
		mysqlConf.put("dialect","org.hibernate.dialect.MySQLDialect");
		mysqlConf.put("show_sql","true");
		//mysqlConf.put("hibernate.current_session_context_class","thread");
		

		
		// 2) adding mysql conigurations to hybernet configuration
		Configuration configuration = new Configuration();
		configuration.setProperties(mysqlConf);
		configuration.addAnnotatedClass(Employee.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(
								new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build()
							);
		Session session = sessionFactory.openSession();  // open session
		
		Employee emp = new Employee();
		emp.setName("Mustaq Ahamed");
		emp.setRole("MD");
		emp.setInsertTime(new Date());
		
		
		session.beginTransaction(); 
		//session.save(emp);
		session.saveOrUpdate(emp);
		session.getTransaction().commit();
		System.out.println(session.isOpen());
		session.close();
		
		
	}

}
