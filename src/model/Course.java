package model;

public class Course {
	private long c_ID;
	private String title;
	private int creditPoints;
	private Professor professor;
	private static long idCounter = 100000;
	
	public Course() {
		idCounter++;
		c_ID = idCounter;
		title = "-title required-";
		creditPoints = 0;
		professor = new Professor();
	}
	
	public Course(String title, int creditPoints, Professor professor) {
		idCounter++;
		this.c_ID = idCounter;
		this.title = title;
		this.creditPoints = creditPoints;
		this.professor = professor;
	}

	public long getC_ID() {
		return c_ID;
	}

	public void setC_ID(long c_ID) {
		if(Utility_class.verifyID(c_ID)) {
			this.c_ID = c_ID;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(Utility_class.isOnlyLetters(title)) {
			this.title = title;
		}
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

	@Override
	public String toString() {
		return "Course [c_ID=" + c_ID + ", title=" + title + ", creditPoints=" + creditPoints + ", professor=" + professor + "]";
	}
	
}
