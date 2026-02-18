package model;

public class Student {
	private long st_ID;
	private String name;
	private String surname;
	
	public Student() {
		st_ID = 0;
		name = "-name required-";
		surname = "-surname required-";
	}
	
	public Student(long st_ID, String name, String surname) {
		this.st_ID = st_ID;
		this.name = name;
		this.surname = surname;
	}

	public long getSt_ID() {
		return st_ID;
	}

	public void setSt_ID(long st_ID) {
		this.st_ID = st_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
