package com.appFive.Hr;







import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appFive.Hr.model.Employee;
import com.appFive.Hr.model.EmployeeDetail;
import com.appFive.Hr.model.jpa.EmployeeDetailJpa;
import com.appFive.Hr.model.jpa.EmployeeJpa;
import com.appFive.Hr.util.HibernateUtil;



public class HrAppJpa {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory("com/appFive/Hr/config/HR_Hibernate.jpa.cfg.xml");
		Session session = sessionFactory.openSession();
		
		Transaction tx = null;
		 try {
		     tx = session.beginTransaction();
		     //do some work
		     EmployeeDetailJpa employeeDetail = new EmployeeDetailJpa("34 cross", "NU", "old Francisco", "U.S.");
		 			
		 	EmployeeJpa employee = new EmployeeJpa("scala", "harington", new  java.sql.Date(121298),"114-857-965");
			
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
		     e.printStackTrace(System.out);
		   
		 }
		 finally {
			 session.close();
		 }
	}

}
