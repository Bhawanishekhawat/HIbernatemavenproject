package com.jcg.hibernate.maven.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
<<<<<<< HEAD

=======
>>>>>>> c9ce8a4cf74078c894b645cd631c77c93ca58127
import com.jcg.hibernate.maven.AppMain;
import com.jcg.hibernate.maven.User;

public class UserDaoImpl implements UserDao {

	public void saveuser(User user) {
<<<<<<< HEAD
		Session session =AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		
=======
		Session session =  AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	
>>>>>>> c9ce8a4cf74078c894b645cd631c77c93ca58127
	}

}
