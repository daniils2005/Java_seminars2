package model;

public class Utility_class {

	public static boolean verifyID(long id) {
		return (id >= 1);
	}

	public static boolean verifyGrade(int grade) {
		return (grade <= 10 && grade >= 1);
	}
	
	public static boolean isOnlyLetters(String name){
		if(name.matches("[A-Z]{1}[a-z]{2,20}([ ]{1}[A-Z]{1}[a-z]{2,20})?")) {
			return true;
		}
		return false;
	}
}
