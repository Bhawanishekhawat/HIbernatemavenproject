package com.jcg.hibernate.maven.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.jcg.hibernate.maven.AppMain;
import com.jcg.hibernate.maven.Student;
import com.jcg.hibernate.maven.User;

public class UserDaoImpl implements UserDao {

	public void saveuser(User user) {
		Session session =AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		
		
		session.save(user);
		transaction.commit();
		
	}
	
	public void getbyId(int id)
	{
		Session session3 =AppMain.getSession();
		Transaction transaction = session3.beginTransaction();
		
		Object o = session3.load(User.class,new Integer(108));
		User s = (User)o;
		System.out.println("Loaded object User name is___"+s.getUsername());
		transaction.commit();
	}
	
	public void updateid(int id)
	{
		Session session3 =AppMain.getSession();
		Transaction transaction = session3.beginTransaction();
		
		Object o = session3.load(User.class,new Integer(108));
		User s = (User)o;
		s.setUsername("bhawani");
		System.out.println("update entry in user");
		transaction.commit();

		
	}
	

}
