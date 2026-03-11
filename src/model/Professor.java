package model;

import model.enums.ProfDegree;

public class Professor {
	private long p_ID;
	private String name;
	private String surname;
	private ProfDegree degree;
	private static long idCounter = 0;

	// default constructor
	public Professor() {
		idCounter++;
		setP_ID(idCounter);
		setName("-name required-");
		setSurname("-surname required-");
		setDegree(ProfDegree.other);
	}

	// parameterized constructor
	public Professor(String name, String surname, ProfDegree degree) {
		idCounter++;
		setP_ID(idCounter);
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}

	public long getP_ID() {
		return p_ID;
	}

	public void setP_ID(long p_ID) {
		if(Utility_class.verifyID(p_ID)) {
			this.p_ID = p_ID;
		} else {
			p_ID = -1;
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

	public ProfDegree getDegree() {
		return degree;
	}

	public void setDegree(ProfDegree degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Professor [p_ID=" + p_ID + ", name=" + name + ", surname=" + surname + ", degree=" + degree + "]";
	}
	
}
