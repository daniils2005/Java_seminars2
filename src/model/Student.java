package model;

public class Student extends Person {
	private long st_ID;
	private static long idCounter = 10000; 
	
	public Student() {
		super(); //izsauksies automatiski Person() konstruktors
		idCounter++;
		setSt_ID(idCounter);
	}
	
	public Student(String name, String surname) {
		super(name, surname);
		idCounter++;
		setSt_ID(idCounter);
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

	@Override
	public String toString() {
		return "Student [st_ID=" + st_ID + ", name=" + name + ", surname=" + surname + "]";
	}

}
