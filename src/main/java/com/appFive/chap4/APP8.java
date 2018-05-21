package com.appFive.chap4;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.appFive.model.Product;

public class APP8 {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate-annotation.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory(
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		
/*			// get all products
			Query query = session.createQuery("from Product");
			List<Product> products = query.list();
			
			System.out.println("=================== Get by All recoeds ===========================");
			for(Product pro : products){
				System.out.println("List of Product::"+pro.getId()+","+pro.getName());
				System.out.println(pro.getCategory().getName());
			}
			*/
			
			/*
			System.out.println("=================== Get by Id ===========================");
			// get by ID
			//HQL example - Get Product with id
			Query query = session.createQuery("from Product where id= :id");
			query.setLong("id", 3);
			Product pro = (Product) query.uniqueResult();
		
			
			System.out.println("=================== Get by Id ===========================");
			System.out.println("Product Name="+pro.getName()+", Price="+pro.getPrice());
			//System.out.println(pro.getCategory().getName());
			System.out.println("=========================================================");
			*/	
/*				
			//HQL Update Employee
		Query query = session.createQuery("update Product set name= :name where id= :id");	
			query.setParameter("name", "MI");
			query.setLong("id", 3);
			int result = query.executeUpdate();
			System.out.println("=================== Update Query ===========================");
			System.out.println("Product Update Status="+result);
			System.out.println("=================== ============ ===========================");
			*/
			
			
			
/*	
			//HQL Delete Employee, we need to take care of foreign key constraints too
		Query query = session.createQuery("delete from Product where id= :id");
			query.setLong("id", 12);
			int result = query.executeUpdate();
			System.out.println("=================== Delet Query ===========================");
			System.out.println("Product Delete Status="+result);
			System.out.println("=================== ============ ===========================");
			*/		
			
		/**/	
			
			//HQL Aggregate function examples
	/*		Query query = session.createQuery("select sum(price) from Product");
			double sumSalary = (Double) query.uniqueResult();
			System.out.println("=================== aggrigate functions Query ===========================");
			System.out.println("Sum of all Product= "+sumSalary);
			System.out.println("=================== sum function  ===========================");
			*/
/*			//Query query = session.createQuery("select max(price) from Product");
			Query query = session.createQuery("form Product where max(price)");
			Product pro = (Product) query.uniqueResult();
		
			
			System.out.println("=================== Get by Id ===========================");
			System.out.println("Product Name="+pro.getName()+", Price="+pro.getPrice());
			//System.out.println(pro.getCategory().getName());
			System.out.println("=========================================================");
			
			*/
			
			//{{
/*			//select e.name, a.city from Employee e  "INNER JOIN e.address a"
			//HQL join examples
			query = session.createQuery("select p.name, c.name from Product p INNER JOIN p.Category c");
			List<Object[]> list = query.list();
			
			System.out.println("=================== innorJoin functions Query ===========================");
			for(Object[] arr : list){
				System.out.println(Arrays.toString(arr));
			}
			System.out.println("=================== ======================== ===========================");
			*/
			//}}
			
		session.getTransaction().commit();
		session.close();
	}

}
