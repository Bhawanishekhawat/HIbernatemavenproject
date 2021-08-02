package com.jcg.hibernate.maven.dao;

import com.jcg.hibernate.maven.AppMain;
import com.jcg.hibernate.maven.Student;

public class StudentDaoImpl implements StudentDao{

	public void saveStudent(Student student) {
		
		AppMain.getSession().save(student);
	}

}
