package com.jcg.hibernate.maven.dao;

import com.jcg.hibernate.maven.Student;

public interface StudentDao {

	 void saveStudent (Student student);
	 void getById(int roll_No);
	 void delete (int rollNo);
	 void update(int rollNo);
}
