package model;

public class Utility_class {

	public static boolean verifyID(long id) {
		return (id >= 1);
	}

	public static boolean verifyGrade(int grade) {
		return (grade <= 10 && grade >= 1);
	}
	
	public static boolean isOnlyLetters(String name){
		for(int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if(!((c >= 65 && c <= 90) || (c >= 97 && c <= 122))) {
				return false;
			}
		}
		return true;
	}
}
