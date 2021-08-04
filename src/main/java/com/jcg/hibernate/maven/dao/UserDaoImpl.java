package com.jcg.hibernate.maven.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.jcg.hibernate.maven.AppMain;
import com.jcg.hibernate.maven.Student;
import com.jcg.hibernate.maven.User;

public class UserDaoImpl implements UserDao {

	public void saveuser(User user) {
		Session session = AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();

	}

	public void getById(int userId) {
		Session session1 = AppMain.getSession();
		Transaction transaction = session1.beginTransaction();
		Object o = session1.load(User.class, new Integer(4));
		User user = (User) o;
		System.out.println("loaded object userName " + user.getUsername());
//		user.setUsername("Sanskar");
//		System.out.println("object updated sucessfully in user table");
		transaction.commit();

	}

	@Override
	public void delete(int userId) {

		Session session2 = AppMain.getSession();
		Transaction transaction = session2.beginTransaction();
		Object o = session2.load(User.class, new Integer(2));
		User user = (User) o;
		session2.delete(user);
		System.out.println("Ram object deleted from user");
		transaction.commit();

	}

	@Override
	public void update(int userId) {
		Session session1 = AppMain.getSession();
		Transaction transaction = session1.beginTransaction();
		Object o = session1.load(User.class, new Integer(6));
		User user = (User) o;
		user.setUsername("Pankaj kumar");
		System.out.println("object updated sucessfully in user table");
		transaction.commit();
	}

}
