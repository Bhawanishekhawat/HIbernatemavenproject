package com.jcg.hibernate.maven.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.jcg.hibernate.maven.AppMain;
import com.jcg.hibernate.maven.Student;
import com.sun.jdi.connect.Connector.IntegerArgument;

public class StudentDaoImpl implements StudentDao {

	public void saveStudent(Student student) {

		Session session = AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();

	}

	public void getById(int roll_No) {
		Session session = AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		Object o = session.load(Student.class, new Integer(5));
		Student s = (Student) o;
		System.out.println("loaded object StudentName " + s.getStudentName());
//		s.setStudentName("Gannu");
//		System.out.println("object updated sucessfully in student table");
		transaction.commit();

	}

	@Override
	public void delete(int rollNo) {
		Session session = AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		Object o = session.load(Student.class, new Integer(1));
		Student s = (Student) o;
		session.delete(s);
		System.out.println("object deleted succesfully from student ");
		transaction.commit();

	}

	@Override
	public void update(int rollNo) {
		Session session = AppMain.getSession();
		Transaction transaction = session.beginTransaction();
		Object o = session.load(Student.class, new Integer(5));
		Student s = (Student) o;
		s.setStudentName("Gannu Singh");
		System.out.println("object updated sucessfully in student table");
		transaction.commit();

		// 2nd type
//		Student std = new Student();
//		std.setRollNo(1);
//		std.setStudentClass(6);
//		std.setAge(11);
//		std.setStudentName("Rishi");
//		session.update(std);
//		System.out.println("object updated successfully by 2nd method");
//		transaction.commit();

	}

}
