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
import com.jcg.hibernate.maven.dao.StudentDao;
import com.jcg.hibernate.maven.dao.StudentDaoImpl;
import com.jcg.hibernate.maven.dao.UserDao;
import com.jcg.hibernate.maven.dao.UserDaoImpl;

public class HqlUserMain {

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

			Query qry1 = sessionObj.createQuery("from User userObj");
			List list1 = qry1.list();
			System.out.println("total no of records in user " + list1.size());

			Iterator it = list1.iterator();
			while (it.hasNext()) {
				Object o = it.next();
				User uobj = (User) o;
				System.out.println("User Name's are " + uobj.getUsername());
			}

			// select query HQL
			Query qry = sessionObj.createQuery("select userObj from User userObj where userObj.username=:name");
			qry.setParameter("name", "Sikha");
			List l = qry.list();
			System.out.println("Total Number Of Records : " + l.size());
			
			Iterator itr = l.iterator();
			while (itr.hasNext()) {
				Object o = (Object) itr.next();
				User uobj = (User) o;
				System.out.println("User Name : " + uobj.getUsername());
				}
			// delete query
			Query qry2 = sessionObj.createQuery("delete from User where username=:name");
			qry2.setParameter("name", "jitesh");
			int result = qry2.executeUpdate();
			System.out.println("no of records effected due to delete query " + result);
			
			// update query
			Query qry3 = sessionObj.createQuery("update User set createdBy=:tech where userid=:id");
//			qry3.setParameter("creat", "Head");
			qry3.setParameter("id", 10);
			int result3 = qry3.executeUpdate();
			List l3 = qry3.list();
			System.out.println("Total Number Of Records : " + l3.size());
			
			User userObj = new User();
			userObj.setUsername("Sanjay");
			userObj.setCreatedBy("IT");
			userObj.setCreatedDate(new Date());

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
