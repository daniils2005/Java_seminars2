package model;

public class Grade {
	private long g_ID;
	private int value;
	private Student student;
	private Course course;
	private static long idCounter = 200000;
	
	public Grade() {
		idCounter++;
		setG_ID(idCounter);
		setValue(1);
		setStudent(new Student());
		setCourse(new Course());
	}
	
	public Grade(int value, Student student, Course course) {
		idCounter++;
		setG_ID(idCounter);
		setValue(value);
		setStudent(student);
		setCourse(course);
	}

	public long getG_ID() {
		return g_ID;
	}

	public void setG_ID(long g_ID) {
		if(Utility_class.verifyID(g_ID)) {
			this.g_ID = g_ID;
		} else {
			this.g_ID = -1;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if(Utility_class.verifyGrade(value)) {
			this.value = value;
		} else {
			this.value = 1;
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		if(student != null) {
			this.student = student;
		} else {
			this.student = new Student();
		}
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		if(course != null) {
			this.course = course;
		} else {
			this.course = new Course();
		}
	}

	@Override
	public String toString() {
		return "Grade [g_ID=" + g_ID + ", value=" + value + ", student=" + student + ", course=" + course + "]";
	}
}
