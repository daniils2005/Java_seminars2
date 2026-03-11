package main;

//importe visas package model klases
import model.*;
//importe klases atseviski
//import model.Course;
//import model.Grade;
//import model.Professor;
//import model.Student;
import model.enums.ProfDegree;
import java.util.ArrayList;
import java.util.Arrays;

public class VeA_IS {
	
	private static ArrayList<Professor> professorLists = new ArrayList<>();
	private static ArrayList<Student> studentLists = new ArrayList<>();
	private static ArrayList<Course> courseLists = new ArrayList<>();
	private static ArrayList<Grade> gradeLists = new ArrayList<>();
	
	public static void main(String[] args) {
		Student stud1 = new Student();
		Student stud2 = new Student("Rendijs", "Serna");
		Student stud3 = new Student("671547", "Ser2d");
		studentLists.add(stud1);
		studentLists.add(stud2);
		studentLists.add(stud3);
		
		System.out.println(studentLists);
		
		Professor prof1 = new Professor();
		Professor prof2 = new Professor("Vairis", "Caune", ProfDegree.phd);
		Professor prof3 = new Professor("Galina", "Hilkevica", ProfDegree.phd);
		professorLists.add(prof1);
		professorLists.add(prof2);
		professorLists.add(prof3);
		
		System.out.println(professorLists);
		
		Course course1 = new Course();
		Course course2 = new Course("Algoritmu teorija", 3, prof2);
		Course course3 = new Course("Matematiska analize", 3, prof3);
		courseLists.addAll(Arrays.asList(course1, course2, course3)); //viena rinda
		
		System.out.println(courseLists);
		
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(10, stud2, course1);
		Grade gr3 = new Grade(7, stud2, course2);
		gradeLists.add(gr1);
		gradeLists.add(gr2);
		gradeLists.add(gr3);
		
		System.out.println(gradeLists);
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
