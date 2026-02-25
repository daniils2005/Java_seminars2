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
	
	private static ArrayList<Professor> professorLists = new ArrayList<>();
	private static ArrayList<Student> studentLists = new ArrayList<>();
	private static ArrayList<Course> courseLists = new ArrayList<>();
	private static ArrayList<Grade> gradeLists = new ArrayList<>();
	
	public static void main(String[] args) {
		Professor professor1 = new Professor("Pname", "Psurname", "Pdegree");
		Student student1 = new Student("Sname", "Ssurname");
		Course course1 = new Course("Programming", 3, professor1);
		Grade grade1 = new Grade(8, student1, course1);

		System.out.println(professor1);
		System.out.println(student1);
		System.out.println(course1);
		System.out.println(grade1);
		
		professorLists.add(professor1);
		studentLists.add(student1);
		courseLists.add(course1);
		gradeLists.add(grade1);
		
	}

	public static double avgGrade(Student student) {
		int temp = 0;
		int count = 0;
		for(int i = 0; i < gradeLists.size(); i++) {
			if(student.getSt_ID() == gradeLists.get(i).getStudent().getSt_ID()) {
				temp += gradeLists.get(i).getValue();
				count++;
			}
		}
		double result = (double)temp / (double)count;
		return result;
	}
	
	public static double weightedAvgGrade(Student student) {
		int up = 0;
		int down = 0;
		for(int i = 0; i < gradeLists.size(); i++) {
			if(student.getSt_ID() == gradeLists.get(i).getStudent().getSt_ID()) {
				up += (gradeLists.get(i).getCourse().getCreditPoints() * gradeLists.get(i).getValue());
				down += gradeLists.get(i).getCourse().getCreditPoints();
			}
		}
		double result = (double)up / (double)down;
		return result;
	}
	
	public static double avgCourseGrade(Course course) {
		int temp = 0;
		int count = 0;
		for(int i = 0; i < gradeLists.size(); i++) {
			if(course.getC_ID() == gradeLists.get(i).getCourse().getC_ID()) {
				temp += gradeLists.get(i).getValue();
				count++;
			}
		}
		double result = (double)temp / (double)count;
		return result;
	}
	
	public static int howManyCourses(Professor professor) {
		int count = 0;
		for(int i = 0; i < courseLists.size(); i++) {
			if(professor.getName() == courseLists.get(i).getProfessor().getName() && professor.getSurname() == courseLists.get(i).getProfessor().getSurname()) {
				count++;
			}
		}
		return count;
	}
	
	public static void sortByAvgGrade() {
		Student temp;
		for(int i = 0; i < studentLists.size(); i++) {
			for(int j = i; j < studentLists.size(); j++) {
				if(avgGrade(studentLists.get(i)) > avgGrade(studentLists.get(j))){
					temp = studentLists.get(i);
					studentLists.set(i, studentLists.get(j));
					studentLists.set(j, temp);
				}
			}
		}
	}
}
