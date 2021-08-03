package com.jcg.hibernate.maven.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jcg.hibernate.maven.AppMain;
import com.jcg.hibernate.maven.Student;

public class StudentDaoImpl implements StudentDao{

	public void saveStudent(Student student) {
		
<<<<<<< HEAD
		Session session = AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		
=======
		Session session =  AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
>>>>>>> c9ce8a4cf74078c894b645cd631c77c93ca58127
	}

}
