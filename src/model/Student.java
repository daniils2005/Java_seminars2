package model;

public class Student {
	private long st_ID;
	private String name;
	private String surname;
	private static long idCounter = 10000; 
	
	public Student() {
		idCounter++;
		setSt_ID(idCounter);
		setName("-name required-");
		setSurname("-surname required-");
	}
	
	public Student(String name, String surname) {
		idCounter++;
		setSt_ID(idCounter);
		setName(name);
		setSurname(surname);
	}

	public long getSt_ID() {
		return st_ID;
	}

	public void setSt_ID(long st_ID) {
		if(Utility_class.verifyID(st_ID)) {
			this.st_ID = st_ID;
		} else {
			this.st_ID = -1;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(Utility_class.isOnlyLetters(name)) {
			this.name = name;
		} else {
			this.name = "-name required-";
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if(Utility_class.isOnlyLetters(surname)) {
			this.surname = surname;
		} else {
			this.surname = "-surname required-";
		}
	}

	@Override
	public String toString() {
		return "Student [st_ID=" + st_ID + ", name=" + name + ", surname=" + surname + "]";
	}
	
}
