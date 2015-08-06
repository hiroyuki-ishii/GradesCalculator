package edu.gatech.seclass.gradescalculator;

import java.util.HashSet;

public class Course {
	private Students _students;
	private Grades _grades;
	
	public Course(Students students, Grades grades) {
		_students = students;
		_grades = grades;
	}

	public int getNumStudents() {
		// TODO Auto-generated method stub
		return _students.getNum();
	}

	public int getNumAssignments() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNumProjects() {
		// TODO Auto-generated method stub
		return 0;
	}

	public HashSet<Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudentByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudentByID(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
