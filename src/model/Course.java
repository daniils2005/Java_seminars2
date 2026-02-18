package model;

public class Course {
	private long c_ID;
	private String title;
	private int creditPoints;
	private Professor professor;
	
	public Course() {
		c_ID = 0;
		title = "-title required-";
		creditPoints = 0;
		professor = new Professor();
	}
	
	public Course(long c_ID, String title, int creditPoints, Professor professor) {
		this.c_ID = c_ID;
		this.title = title;
		this.creditPoints = creditPoints;
		this.professor = professor;
	}

	public long getC_ID() {
		return c_ID;
	}

	public void setC_ID(long c_ID) {
		this.c_ID = c_ID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCreditPoints() {
		return creditPoints;
	}

	public void setCreditPoints(int creditPoints) {
		this.creditPoints = creditPoints;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
