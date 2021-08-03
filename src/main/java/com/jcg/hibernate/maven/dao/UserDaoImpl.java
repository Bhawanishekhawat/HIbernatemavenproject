package com.jcg.hibernate.maven.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.jcg.hibernate.maven.AppMain;
import com.jcg.hibernate.maven.User;

public class UserDaoImpl implements UserDao {

	public void saveuser(User user) {
		Session session =  AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	
	}

}
