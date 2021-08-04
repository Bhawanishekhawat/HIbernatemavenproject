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
	
	public void getbyId(int rollNo)
	{
		Session session2 = AppMain.getSession();
		Transaction transaction = session2.beginTransaction();
		Object o = session2.load(Student.class, new Integer(11));
		Student s = (Student)o;
		System.out.println("Loaded object product name is___"+s.getStudentName());
		transaction.commit();
		
	}
	
	public void delete(int rollNo)
	{
		Session session3 = AppMain.getSession();
		Transaction transaction = session3.beginTransaction();
		Object o = session3.load(Student.class, new Integer(11));
		Student s = (Student)o;
		session3.delete(s);
		transaction.commit();
		
	}
	
	
	public void updateid(int rollNo)
	{
		Session session3 = AppMain.getSession();
		Transaction transaction = session3.beginTransaction();
		Object o = session3.load(Student.class, new Integer(11));
		Student s = (Student)o;
		s.setStudentName("karan");
		System.out.println("updated name "+s.getStudentName());
		transaction.commit();
		
		
		
	}

}
