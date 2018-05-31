package com.appFive.Hr.util;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	 private static  SessionFactory sessionFactory = null;

	 
	    private static SessionFactory buildSessionFactory(String string) {
	    	Configuration configuration = new Configuration();
	    	configuration.configure(string);
	    	
	    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
		  }
	 
	    public static SessionFactory getSessionFactory(String hibernetConfitFile) {
	    	
	    	 if (sessionFactory==null) {
	    		    sessionFactory = buildSessionFactory(hibernetConfitFile);
	    	 }
	    	DisplayEneitiClasses();
	        return sessionFactory;
	    }
	    
	    
	    public static void DisplayEneitiClasses() {
	    	
	    	System.out.println("=========================List of Model loaded ===========================");
			Map<String, ClassMetadata>  map = (Map<String, ClassMetadata>) sessionFactory.getAllClassMetadata();
			
			System.out.println("----------------------------------------------------");
			System.out.printf("%-50s%-22s\n","Class Name","Database Table name");
			System.out.println("----------------------------------------------------");
			
			for(String entityName : map.keySet()){
		        SessionFactoryImpl sfImpl = (SessionFactoryImpl) sessionFactory;
		        String tableName = ((AbstractEntityPersister)sfImpl.getEntityPersister(entityName)).getTableName();
		        System.out.printf("%-50s%-22s\n",entityName,tableName);
		        
		    }
			System.out.println("----------------------------------------------------");
			System.out.println("========================================================================");
	    }
}
