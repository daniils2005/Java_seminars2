package model;

public class Course {
	private long c_ID;
	private String title;
	private int creditPoints;
	private Professor professor;
	private static long idCounter = 100000;
	
	public Course() {
		idCounter++;
		setC_ID(idCounter);
		setTitle("-title required-");
		setCreditPoints(0);
		setProfessor(new Professor());
	}
	
	public Course(String title, int creditPoints, Professor professor) {
		idCounter++;
		setC_ID(idCounter);
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfessor(professor);
	}

	public long getC_ID() {
		return c_ID;
	}

	public void setC_ID(long c_ID) {
		if(Utility_class.verifyID(c_ID)) {
			this.c_ID = c_ID;
		} else {
			this.c_ID = -1;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if((title != null) && (title.matches("[A-Z]{1}[A-Za-z0-9 ]{1,40}"))) {
			this.title = title;
		} else {
			this.title = "-title required-";
		}
	}

	public int getCreditPoints() {
		return creditPoints;
	}

	public void setCreditPoints(int creditPoints) {
		if(creditPoints >= 1 && creditPoints <= 30) {
			this.creditPoints = creditPoints;
		} else {
			this.creditPoints = 1;
		}
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		if(professor != null) {
			this.professor = professor;
		} else {
			this.professor = new Professor();
		}
	}

	@Override
	public String toString() {
		return "Course [c_ID=" + c_ID + ", title=" + title + ", creditPoints=" + creditPoints + "CP, professor=" + professor + "]";
	}
	
}
