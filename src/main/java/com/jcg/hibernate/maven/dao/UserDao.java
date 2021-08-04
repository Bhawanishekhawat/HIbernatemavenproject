package com.jcg.hibernate.maven.dao;

import com.jcg.hibernate.maven.User;

public interface UserDao {
	
	void saveuser(User user);
	void getbyId(int id);
	void updateid(int id);

}
