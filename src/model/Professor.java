package model;

public class Professor {
	private long p_ID;
	private String name;
	private String surname;
	private String degree;
	private static long idCounter = 0;

	// default constructor
	public Professor() {
		idCounter++;
		p_ID = idCounter;
		name = "-name required-";
		surname = "-surname required-";
		String degree = "-degree required-";
	}

	// parameterized constructor
	public Professor(String name, String surname, String degree) {
		idCounter++;
		this.p_ID = idCounter;
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}

	public long getP_ID() {
		return p_ID;
	}

	public void setP_ID(long p_ID) {
		if(Utility_class.verifyID(p_ID)) {
			this.p_ID = p_ID;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		if(Utility_class.isOnlyLetters(degree)) {
			this.degree = degree;
		}
	}

	@Override
	public String toString() {
		return "Professor [p_ID=" + p_ID + ", name=" + name + ", surname=" + surname + ", degree=" + degree + "]";
	}
	
}
