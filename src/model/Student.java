package model;

public class Student {
	private long st_ID;
	private String name;
	private String surname;
	private static long idCounter = 10000; 
	
	public Student() {
		idCounter++;
		st_ID = idCounter;
		name = "-name required-";
		surname = "-surname required-";
		
	}
	
	public Student(String name, String surname) {
		idCounter++;
		this.st_ID = idCounter;
		this.name = name;
		this.surname = surname;
	}

	public long getSt_ID() {
		return st_ID;
	}

	public void setSt_ID(long st_ID) {
		if(Utility_class.verifyID(st_ID)) {
			this.st_ID = st_ID;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(Utility_class.isOnlyLetters(name)) {
			this.name = name;
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if(Utility_class.isOnlyLetters(surname)) {
			this.surname = surname;
		}
	}

	@Override
	public String toString() {
		return "Student [st_ID=" + st_ID + ", name=" + name + ", surname=" + surname + "]";
	}
	
}
