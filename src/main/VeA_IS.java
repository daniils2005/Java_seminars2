package main;

//importe visas package model klases
import model.*;
//importe klases atseviski
//import model.Course;
//import model.Grade;
//import model.Professor;
//import model.Student;

import java.util.ArrayList;

public class VeA_IS {

	public static void main(String[] args) {
		Professor professor1 = new Professor("Pname", "Psurname", "Pdegree");
		Student student1 = new Student("Sname", "Ssurname");
		Course course1 = new Course("Programming", 3, professor1);
		Grade grade1 = new Grade(8, student1, course1);

		System.out.println(professor1.toString());
		System.out.println(student1.toString());
		System.out.println(course1.toString());
		System.out.println(grade1.toString());
		
		ArrayList<Professor> professorLists = new ArrayList<>();
		ArrayList<Student> studentLists = new ArrayList<>();
		ArrayList<Course> courseLists = new ArrayList<>();
		ArrayList<Grade> gradeLists = new ArrayList<>();
		
		professorLists.add(professor1);
		studentLists.add(student1);
		courseLists.add(course1);
		gradeLists.add(grade1);
		
	}

}
