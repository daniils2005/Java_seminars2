package model;

public class Person {
	//1 mainigie
	protected String name;
	protected String surname;
	//2 getters
	//3 setters
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
	//4 no args constr
	public Person() {
		setName("-name required-");
		setSurname("-surname required-");
	}
	//5 args construct
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	//6. toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + "]";
	}
	
}
