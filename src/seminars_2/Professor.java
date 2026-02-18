package seminars_2;

public class Professor {
	private long p_ID;
	private String name;
	private String surname;
	private String degree;

	// default constructor
	public Professor() {
		p_ID = 0;
		name = "-name required-";
		surname = "-surname required-";
		String degree = "-degree required-";
	}

	// parameterized constructor
	public Professor(long p_ID, String name, String surname, String degree) {
		this.p_ID = p_ID;
		this.name = name;
		this.name = surname;
		this.name = degree;
	}

	public long getP_ID() {
		return p_ID;
	}

	public void setP_ID(long p_ID) {
		this.p_ID = p_ID;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
}
