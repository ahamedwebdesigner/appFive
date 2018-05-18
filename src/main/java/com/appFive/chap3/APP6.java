package com.appFive.chap3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.appFive.model.Category;
import com.appFive.model.Product;

public class APP6 {

	public static void main(String[] args) {
		
		
		Configuration configuration = new Configuration();
	/*	
	  // 1) adding maping information to the config file
	  configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Category.class);
		configuration.addAnnotatedClass(Product.class);
		*/
		
		//2) second one adding maping information with in the config file
		configuration.configure("hibernate-annotation.cfg.xml");
		
		
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(new StandardServiceRegistryBuilder(
						).applySettings(configuration.getProperties()).build());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Category category = new Category("car");
		Product pc = new Product("bladeRunner", "blade", 12000, category);
		
		
		session.save(category);
		session.save(pc);
		
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Recod entered");

	}

}
