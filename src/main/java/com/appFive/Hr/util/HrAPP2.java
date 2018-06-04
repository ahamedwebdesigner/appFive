package com.appFive.Hr.util;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appFive.Hr.model.Employee;

public class HrAPP2 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory("com/appFive/Hr/config/HR_Hibernate.cfg.xml");
		Session session = sessionFactory.openSession();
		
		
		Transaction tx = session.beginTransaction();
		 SQLQuery query = session.createSQLQuery("select employee_id, firstname, lastname, birth_date, cell_phone from appfive.Employee");
		
		
		
		List<Object[]> rows = query.list();
		
		for(Object[] row : rows){
			System.out.println("-------------------");
			System.out.println( row[0].toString() );
			System.out.println("-------------------");
			Employee emp = new Employee();
			emp.setEmployeeId(Long.parseLong(row[0].toString()));
			emp.setFirstname(row[1].toString());
			emp.setLastname(row[2].toString());
			
		
			System.out.println(emp);
		}
		
		
		

	
		
		

	}

}
