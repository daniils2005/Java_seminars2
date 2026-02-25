package model;

public class Grade {
	private long g_ID;
	private int value;
	private Student student;
	private Course course;
	private static long idCounter = 200000;
	
	public Grade() {
		idCounter++;
		g_ID = idCounter;
		value = 0;
		student = new Student();
		course = new Course();
	}
	
	public Grade(int value, Student student, Course course) {
		idCounter++;
		this.g_ID = idCounter;
		this.value = value;
		this.student = student;
		this.course = course;
	}

	public long getG_ID() {
		return g_ID;
	}

	public void setG_ID(long g_ID) {
		if(Utility_class.verifyID(g_ID)) {
			this.g_ID = g_ID;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if(Utility_class.verifyGrade(value)) {
			this.value = value;
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Grade [g_ID=" + g_ID + ", value=" + value + ", student=" + student + ", course=" + course + "]";
	}
}
