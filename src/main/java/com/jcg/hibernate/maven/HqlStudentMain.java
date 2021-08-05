package com.jcg.hibernate.maven;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class HqlStudentMain {
	
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();

		configObj.configure("hibernate.cfg.xml");
		configObj.addAnnotatedClass(Student.class);
		configObj.addAnnotatedClass(User.class);

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static Session getSession() {
		return buildSessionFactory().openSession();
	}

	public static void main(String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			Query qry = sessionObj.createQuery("from Student stobj");
			List list = qry.list();
			
			System.out.println("total no of records in student  " + list.size());

			Iterator itr = list.iterator();

			while (itr.hasNext()) {

				Object obj = itr.next();
				Student stobj = (Student) obj;

				System.out.println("student age " + stobj.getAge());
//				System.out.println("student class " + stobj.getStudentClass());
//				System.out.println("student Name " + stobj.getStudentName());
				
						}
			
					
			Student stobj = new Student();
			stobj.setStudentName("monu");
			stobj.setStudentClass(10);
			stobj.setAge(18);

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

}
