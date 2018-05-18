package com.appFive.chap3;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.appFive.model.Category;
import com.appFive.model.Product;

public class APP7 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate-annotation.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory(
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Category category = new Category("Streetbikes");
        Product KTM = new Product("KTM400", "Fastes and Feurious", 200000, category);
        Product Dominar = new Product("Dominar600", "Loud and fast", 300000, category);

		Set<Product> products = new HashSet<Product>();
		products.add(KTM);
		products.add(Dominar);
		category.setProducts(products);
		session.save(category);

		session.getTransaction().commit();
		session.close();

		System.out.println("Recod entered");

	}

}
