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
		
		System.out.println("----------CRUD TESTING----------");
		try {
			createStudent("Janis", "Berzins");
			System.out.println(studentLists);
			System.out.println(getStudentById(10001));
			System.out.println(updateById(10002, "Rendijs", "Jaukais")); //Nomainits Rendija uzvards
			System.out.println(studentLists);
			deleteById(10003);
			System.out.println(studentLists);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
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
	
	
	//CRUD - C - create, R - retrieve, U - update, D - delete
	
	//C - create student
	public static void createStudent(String inputName, String inputSurname) throws Exception {
		//TODO parbaudiet ienakosos parametrus
		
		for(var i : studentLists) {
			if(i.getName().equals(inputName) && i.getSurname().equals(inputSurname)) {
				throw new Exception("Tads students jau eksiste");
			}
		}
		
		studentLists.add(new Student(inputName, inputSurname));
	}
	
	//R - retrieve by ID
	public static Student getStudentById(long id) throws Exception {
		if(id < 0) {
			throw new Exception("Id nevar but negativs");
		}
		
		for(var i : studentLists) {
			if(i.getSt_ID() == id) {
				return i;
			}
		}
		
		throw new Exception("Students ar id " + id + " neeksiste");
		
	}
	
	//U - update
	public static Student updateById(int id, String inputName, String inputSurname) throws Exception {
		Student studentForUpdating = getStudentById(id);
		
		//TODO parbaudit inputName un inputSurname
		if(!studentForUpdating.getName().equals(inputName)) {
			studentForUpdating.setName(inputName);
		}
		
		if(!studentForUpdating.getSurname().equals(inputSurname)) {
			studentForUpdating.setSurname(inputSurname);
		}
		
		return studentForUpdating;
		
	}
	
	//D - delete
	
	public static void deleteById(int id) throws Exception {
		Student studentForDeleting = getStudentById(id);
		studentLists.remove(studentForDeleting);
	}
	
	//izfiltret un atgriezt visus profesorus, kuru degree ir master
	public static ArrayList<Professor> professorsWithMasterDegree(){
		ArrayList<Professor> masters = new ArrayList<>();
		for(var i : professorLists) {
			if(i.getDegree() == ProfDegree.master) {
				masters.add(i);
			}
		}
		return masters;
	}
	
	public static ArrayList<Professor> professorsWithMasterDegree(ProfDegree inputDegree) throws Exception {
		if(inputDegree == null) {
			throw new Exception("Neeksistejoss grads");
		}
		ArrayList<Professor> result = new ArrayList<>();
		for(var i : professorLists) {
			if(i.getDegree().equals(inputDegree)) {
				result.add(i);
			}
		}
		if(result.isEmpty()) {
			throw new Exception("Sistema nav profesoru ar " + inputDegree + " gradu");
		}
		return result;
	}
	
}

