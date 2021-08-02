package com.jcg.hibernate.maven.dao;

import com.jcg.hibernate.maven.AppMain;
import com.jcg.hibernate.maven.User;

public class UserDaoImpl implements UserDao {

	public void saveuser(User user) {
		AppMain.getSession().save(user);
	}

}
