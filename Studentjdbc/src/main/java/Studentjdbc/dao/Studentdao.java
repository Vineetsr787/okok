package Studentjdbc.dao;

import java.util.List;

import Studentjdbc.model.Student;

public interface Studentdao {
	public List<Student> listAll();
	public String addData(Student std);
	public String deleteData(String fname);
	public Student searchTable(String fname);

}
