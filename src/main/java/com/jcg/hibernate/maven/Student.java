package com.jcg.hibernate.maven;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9053446927758157619L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Roll_No")
	private int rollNo;

	@Column(name = "Name")
	private String studentName;

	@Column(name = "Class_Standard")
	private int studentClass;

	@Column(name = "Student_Age")
	private int age;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", studentName=" + studentName + ", studentClass=" + studentClass
				+ ", age=" + age + "]";
	}

}
