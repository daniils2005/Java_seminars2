package model;

import model.enums.ProfDegree;

public class Professor extends Person {
	private long p_ID;
	private ProfDegree degree;
	private static long idCounter = 0;

	// default constructor
	public Professor() {
		super();
		idCounter++;
		setP_ID(idCounter);
		setDegree(ProfDegree.other);
	}

	// parameterized constructor
	public Professor(String name, String surname, ProfDegree degree) {
		super(name, surname);
		idCounter++;
		setP_ID(idCounter);
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

	public ProfDegree getDegree() {
		return degree;
	}

	public void setDegree(ProfDegree degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Professor [p_ID=" + p_ID + ", degree=" + degree + ", name=" + name + ", surname=" + surname + "]";
	}

}
