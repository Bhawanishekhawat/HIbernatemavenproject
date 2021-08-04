package com.jcg.hibernate.maven.dao;

import com.jcg.hibernate.maven.User;

public interface UserDao {
	
	void saveuser(User user);
	void getById(int userId);
	void delete (int userId);
	void update(int userId);
	

}
