package com.jcg.hibernate.maven.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jcg.hibernate.maven.AppMain;
import com.jcg.hibernate.maven.Student;

public class StudentDaoImpl implements StudentDao{

	public void saveStudent(Student student) {
		
		Session session =  AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
	}

}
