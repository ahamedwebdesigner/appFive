package com.appFive.chap3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.appFive.model.Category;
import com.appFive.model.Product;


public class App5 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate-xml-maping.cfg.xml");
		
		/* Building SessionFactory */
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(new StandardServiceRegistryBuilder(
						).applySettings(configuration.getProperties()).build());
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		
	/*	Category category = new Category("Mobile");
		Product pc = new Product("Readmi", "blade", 12000, category);
		
		
		session.save(category);
		session.save(pc);
		*/
		
		
		// In order to work bi directional query just rid off to string methods in category class
/* */    List ProductList = session.createQuery("FROM Product").list();
		 System.out.println(ProductList.get(0));
		 System.out.println(ProductList.get(1));
		 System.out.println(ProductList.get(2));
		 System.out.println(ProductList.get(3));
		 System.out.println(ProductList.get(4));
		
/**/	List CategorytList = session.createQuery("FROM Category").list();
		 System.out.println(CategorytList.get(1));  
		
		session.getTransaction().commit();
		session.close();
		

	}

}
