package com.jcg.hibernate.maven.dao;

import com.jcg.hibernate.maven.Student;

public interface StudentDao {

	 void saveStudent (Student student);
	 void getbyId(int rollNo);
	// void delete(int rollNo);
	 void updateid(int rollNo);
	 
}
