package com.appFive.Hr;







import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appFive.Hr.model.Employee;
import com.appFive.Hr.model.EmployeeDetail;
import com.appFive.Hr.util.HibernateUtil;



public class HrApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory("com/appFive/Hr/config/HR_Hibernate.cfg.xml");
		Session session = sessionFactory.openSession();
		
		 Transaction tx = null;
		 try {
		     tx = session.beginTransaction();
		     //do some work
		 	EmployeeDetail employeeDetail = new EmployeeDetail("13 cross", "LA", "new Francisco", "U.S.");
			
			Employee employee = new Employee("blis", "one", new  java.sql.Date(121212),"114-857-965");
			
			Date now = new Date();
			employee.setInsertDate(now);
			employee.setInsertTime(now);
			employee.setModifiedDateTime(now);
			
		
			
			employee.setEmployeeDetail(employeeDetail);
			employeeDetail.setEmployee(employee);
			
			
			session.save(employee);
		     tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     System.out.println("data is not saved");
		   
		 }
		 finally {
			 session.close();
		 }
	}

}
