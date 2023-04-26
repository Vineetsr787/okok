package Studentjdbc.model;

public class Student {
	String fname;
	String lname;
	int age;
	String gender;
	
	public Student() {
		
	}

	public Student(String fname, String lname, int age, String gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + ", age=" + age + ", gender=" + gender + "]";
	}

}
