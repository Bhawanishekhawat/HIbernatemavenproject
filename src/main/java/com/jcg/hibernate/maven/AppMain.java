package com.jcg.hibernate.maven;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.jcg.hibernate.maven.dao.StudentDao;
import com.jcg.hibernate.maven.dao.StudentDaoImpl;
import com.jcg.hibernate.maven.dao.UserDao;
import com.jcg.hibernate.maven.dao.UserDaoImpl;

public  class AppMain {

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

	// static method
	// addStudent

	public static Session getSession() {
		return buildSessionFactory().openSession();
	}

	public static void main(String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");
		try {

			Student stobj = new Student();

			stobj.setRollNo(11);
			stobj.setStudentName("Ram");
			stobj.setStudentClass(5);
			stobj.setAge(10);

			User userObj = new User();

			userObj.setUserid(108);
			userObj.setUsername("Shyam ");
			userObj.setCreatedBy("Admin");
			userObj.setCreatedDate(new Date());

//				sessionObj.save(userObj);

			StudentDao sdiobj = new StudentDaoImpl();
			sdiobj.saveStudent(stobj);

			UserDao udiobj = new UserDaoImpl();
			udiobj.saveuser(userObj);

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// student method call
//		AppMain  am = new AppMain();
//		am.addStudent();
//			sessionObj.save(stobj);

			System.out.println("/n Student data saved succesfully /n");

			// Committing The Transactions To The Database
		} catch (Exception sqlException) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
			}
		} 
	}
